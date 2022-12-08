-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 08, 2022 at 06:28 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospital`
--

-- --------------------------------------------------------

--
-- Table structure for table `admission_details`
--

CREATE TABLE `admission_details` (
  `admission_id` int(11) NOT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `guardian_name` varchar(150) DEFAULT NULL,
  `guardian_phone` varchar(50) NOT NULL,
  `room_ward_no` int(11) DEFAULT NULL,
  `bad_no` int(11) DEFAULT NULL,
  `ref_doctor` varchar(150) DEFAULT NULL,
  `admission_date` varchar(50) DEFAULT NULL,
  `admission_time` varchar(85) DEFAULT NULL,
  `emergency` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admission_details`
--

INSERT INTO `admission_details` (`admission_id`, `patient_id`, `guardian_name`, `guardian_phone`, `room_ward_no`, `bad_no`, `ref_doctor`, `admission_date`, `admission_time`, `emergency`) VALUES
(1, 1, 'adasd', '23123', 1, 1, 'wadasd', '12/12/2022', '12:12 AM', 'No');

-- --------------------------------------------------------

--
-- Table structure for table `appointment_bill`
--

CREATE TABLE `appointment_bill` (
  `appointment_bill_id` int(11) NOT NULL,
  `appointment_id` int(11) DEFAULT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `bil_date` date DEFAULT NULL,
  `appointment_charge` int(11) DEFAULT NULL,
  `hospital_charge` int(11) DEFAULT NULL,
  `grand_total` int(11) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  `net_value` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `appointment_bill_payment`
--

CREATE TABLE `appointment_bill_payment` (
  `bill_payment_id` int(11) NOT NULL,
  `appointment_bill_id` int(11) DEFAULT NULL,
  `amount_paid` int(11) DEFAULT NULL,
  `paid_date` date DEFAULT NULL,
  `payment_type` varchar(85) DEFAULT NULL,
  `checkno` varchar(85) DEFAULT NULL,
  `checkdate` date DEFAULT NULL,
  `bank` varchar(85) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bad_details`
--

CREATE TABLE `bad_details` (
  `bed_id` int(11) NOT NULL,
  `room_ward_id` int(11) DEFAULT NULL,
  `available` int(11) DEFAULT NULL,
  `admission_id` int(11) DEFAULT NULL,
  `bed_desc` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `customer_id` int(11) NOT NULL,
  `company_name` varchar(150) DEFAULT NULL,
  `contact_first_name` varchar(150) DEFAULT NULL,
  `contact_last_name` varchar(150) DEFAULT NULL,
  `billing_address` varchar(255) DEFAULT NULL,
  `city` varchar(150) DEFAULT NULL,
  `state_of_province` varchar(150) DEFAULT NULL,
  `postal_code` int(11) DEFAULT NULL,
  `country` varchar(150) DEFAULT NULL,
  `contact_title` varchar(150) DEFAULT NULL,
  `phone_number` varchar(85) DEFAULT NULL,
  `extension` varchar(150) DEFAULT NULL,
  `fax_number` varchar(150) DEFAULT NULL,
  `email_address` varchar(150) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `dept_id` int(11) NOT NULL,
  `dept_name` varchar(85) DEFAULT NULL,
  `recstate` varchar(85) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `department_details`
--

CREATE TABLE `department_details` (
  `department_id` int(11) NOT NULL,
  `department_name` varchar(150) DEFAULT NULL,
  `descripation` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `doctor_appointment`
--

CREATE TABLE `doctor_appointment` (
  `appointment_id` int(11) NOT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `appointment_date` varchar(85) DEFAULT NULL,
  `appointment_time` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor_appointment`
--

INSERT INTO `doctor_appointment` (`appointment_id`, `patient_id`, `doctor_id`, `appointment_date`, `appointment_time`) VALUES
(1, 1, 1, '10/12/2022', '10:10 AM');

-- --------------------------------------------------------

--
-- Table structure for table `doctor_dtls`
--

CREATE TABLE `doctor_dtls` (
  `doctor_id` int(11) NOT NULL,
  `doctor_fname` varchar(150) DEFAULT NULL,
  `doctor_lname` varchar(150) DEFAULT NULL,
  `doctor_sex` varchar(50) DEFAULT NULL,
  `doctor_nid` varchar(150) DEFAULT NULL,
  `doctor_hphone` varchar(15) DEFAULT NULL,
  `doctor_mphone` varchar(15) DEFAULT NULL,
  `doctor_address` varchar(255) DEFAULT NULL,
  `doctor_qualfication` varchar(150) DEFAULT NULL,
  `doctor_specialization` varchar(150) DEFAULT NULL,
  `doctor_type` varchar(50) DEFAULT NULL,
  `doctor_vcharge` int(11) DEFAULT NULL,
  `doctor_ccharge` int(11) DEFAULT NULL,
  `doctor_notes` varchar(150) DEFAULT NULL,
  `doctor_basic_sal` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor_dtls`
--

INSERT INTO `doctor_dtls` (`doctor_id`, `doctor_fname`, `doctor_lname`, `doctor_sex`, `doctor_nid`, `doctor_hphone`, `doctor_mphone`, `doctor_address`, `doctor_qualfication`, `doctor_specialization`, `doctor_type`, `doctor_vcharge`, `doctor_ccharge`, `doctor_notes`, `doctor_basic_sal`) VALUES
(1, NULL, NULL, 'Male', 'scadd', '', NULL, '', 'Male', 'Male', 'Male', 0, 0, NULL, NULL),
(2, NULL, NULL, 'Male', 'asd', 'ad', NULL, '', 'LMAF', 'Child specialist', 'Active', 3, 3, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `doctor_salary`
--

CREATE TABLE `doctor_salary` (
  `decode` int(11) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `ch` int(11) DEFAULT NULL,
  `vc` int(11) DEFAULT NULL,
  `basic` int(11) DEFAULT NULL,
  `da` int(11) DEFAULT NULL,
  `hra` int(11) DEFAULT NULL,
  `cca` int(11) DEFAULT NULL,
  `trans` int(11) DEFAULT NULL,
  `gpf` int(11) DEFAULT NULL,
  `ins` int(11) DEFAULT NULL,
  `itax` int(11) DEFAULT NULL,
  `ptax` int(11) DEFAULT NULL,
  `gross` int(11) DEFAULT NULL,
  `deduct` int(11) DEFAULT NULL,
  `net` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `doctor_schedule`
--

CREATE TABLE `doctor_schedule` (
  `schedule_id` int(11) NOT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `doctor_in` varchar(85) DEFAULT NULL,
  `doctor_out` varchar(85) DEFAULT NULL,
  `doctor_avaidate` date DEFAULT NULL,
  `schedule_notes` varchar(85) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `doctor_schedule_details`
--

CREATE TABLE `doctor_schedule_details` (
  `schedule_id` int(11) NOT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `doctor_in` varchar(50) DEFAULT NULL,
  `doctor_out` varchar(50) DEFAULT NULL,
  `doctor_avaidate` date DEFAULT NULL,
  `schedule_notes` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `emp_id` int(11) NOT NULL,
  `emp_name` varchar(150) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `telephone` varchar(85) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `sex` varchar(15) DEFAULT NULL,
  `department` varchar(150) DEFAULT NULL,
  `in_cop` int(11) DEFAULT NULL,
  `in_num` int(11) DEFAULT NULL,
  `bsal` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee_details`
--

CREATE TABLE `employee_details` (
  `employee_id` int(11) NOT NULL,
  `employee_name` varchar(150) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `telephone` varchar(85) DEFAULT NULL,
  `dateofbirth` date DEFAULT NULL,
  `sex` varchar(15) DEFAULT NULL,
  `department` varchar(150) DEFAULT NULL,
  `insurance_company` varchar(150) DEFAULT NULL,
  `insurance_number` varchar(85) DEFAULT NULL,
  `basic_salary` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee_doctor_salary`
--

CREATE TABLE `employee_doctor_salary` (
  `doctor_salid` int(11) NOT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `da` int(11) DEFAULT NULL,
  `hra` int(11) DEFAULT NULL,
  `cca` int(11) DEFAULT NULL,
  `trans` int(11) DEFAULT NULL,
  `gpf` int(11) DEFAULT NULL,
  `ins` int(11) DEFAULT NULL,
  `itax` int(11) DEFAULT NULL,
  `ptax` int(11) DEFAULT NULL,
  `gross` int(11) DEFAULT NULL,
  `deduct` int(11) DEFAULT NULL,
  `net` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `salary_month` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee_salary`
--

CREATE TABLE `employee_salary` (
  `salary_id` int(11) NOT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `basic` int(11) DEFAULT NULL,
  `da` int(11) DEFAULT NULL,
  `hra` int(11) DEFAULT NULL,
  `cca` int(11) DEFAULT NULL,
  `trans` int(11) DEFAULT NULL,
  `gpf` int(11) DEFAULT NULL,
  `ins` int(11) DEFAULT NULL,
  `itax` int(11) DEFAULT NULL,
  `ptax` int(11) DEFAULT NULL,
  `gross` int(11) DEFAULT NULL,
  `deduct` int(11) DEFAULT NULL,
  `net` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `salary_month` varchar(85) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `guardian_details`
--

CREATE TABLE `guardian_details` (
  `guardian_id` int(11) NOT NULL,
  `guardian_fname` varchar(150) DEFAULT NULL,
  `guardian_lanme` varchar(150) DEFAULT NULL,
  `guardian_nic` varchar(150) DEFAULT NULL,
  `guardian_address` varchar(255) DEFAULT NULL,
  `guardian_phone` varchar(35) DEFAULT NULL,
  `guardian_fax` varchar(150) DEFAULT NULL,
  `guardian_occupation` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hospital_charges`
--

CREATE TABLE `hospital_charges` (
  `id` int(11) NOT NULL,
  `hospital_id` int(11) DEFAULT NULL,
  `vat_rate` int(11) DEFAULT NULL,
  `discount_date` int(11) DEFAULT NULL,
  `hospital_rate` int(11) DEFAULT NULL,
  `other` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hospital_details`
--

CREATE TABLE `hospital_details` (
  `hospital_id` int(11) NOT NULL,
  `hospital_name` varchar(150) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `telephone` varchar(85) DEFAULT NULL,
  `fax` varchar(150) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `web_site` varchar(150) DEFAULT NULL,
  `registration_number` varchar(85) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `inpatient_orders`
--

CREATE TABLE `inpatient_orders` (
  `order_id` int(11) NOT NULL,
  `admission_id` int(11) DEFAULT NULL,
  `order_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `inpatient_order_details`
--

CREATE TABLE `inpatient_order_details` (
  `order_details_id` int(11) NOT NULL,
  `order_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `date_sold` date DEFAULT NULL,
  `quantity` varchar(150) DEFAULT NULL,
  `unit_price` int(11) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `in_patient_details`
--

CREATE TABLE `in_patient_details` (
  `patient_id` int(11) NOT NULL,
  `patient_fname` varchar(150) DEFAULT NULL,
  `patient_lname` varchar(150) DEFAULT NULL,
  `patient_dob` date DEFAULT NULL,
  `patient_sex` varchar(15) DEFAULT NULL,
  `patient_nid` varchar(35) DEFAULT NULL,
  `patient_hphone` varchar(15) DEFAULT NULL,
  `patient_mphone` varchar(15) DEFAULT NULL,
  `patient_address` varchar(255) DEFAULT NULL,
  `patient_hight` int(11) DEFAULT NULL,
  `patient_weight` int(11) DEFAULT NULL,
  `patient_blood_group` varchar(15) DEFAULT NULL,
  `patient_notes` varchar(150) DEFAULT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `in_patient_details`
--

INSERT INTO `in_patient_details` (`patient_id`, `patient_fname`, `patient_lname`, `patient_dob`, `patient_sex`, `patient_nid`, `patient_hphone`, `patient_mphone`, `patient_address`, `patient_hight`, `patient_weight`, `patient_blood_group`, `patient_notes`, `status`) VALUES
(1, 'adasd', NULL, NULL, 'Male', '123123', NULL, '123', 'asdasd', 6, 6, 'A', NULL, 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `in_patient_detls`
--

CREATE TABLE `in_patient_detls` (
  `patient_id` int(11) NOT NULL,
  `patient_fname` varchar(150) DEFAULT NULL,
  `patient_lname` varchar(150) DEFAULT NULL,
  `patient_bob` varchar(150) DEFAULT NULL,
  `patient_sex` varchar(85) DEFAULT NULL,
  `patient_nid` varchar(150) DEFAULT NULL,
  `patient_hpone` varchar(85) DEFAULT NULL,
  `patient_mphone` varchar(85) DEFAULT NULL,
  `patient_address` varchar(255) DEFAULT NULL,
  `patient_hight` int(11) DEFAULT NULL,
  `patient_weight` int(11) DEFAULT NULL,
  `patient_blood_group` varchar(30) DEFAULT NULL,
  `patient_notes` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `in_patient_discharge`
--

CREATE TABLE `in_patient_discharge` (
  `discharge_id` int(11) NOT NULL,
  `admission_id` int(11) DEFAULT NULL,
  `discharge_date` date DEFAULT NULL,
  `discharge_time` varchar(85) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `in_patient_services`
--

CREATE TABLE `in_patient_services` (
  `inpatient_serviceid` int(11) NOT NULL,
  `inpatient_id` int(11) DEFAULT NULL,
  `admission_id` int(11) DEFAULT NULL,
  `hospital_service_id` int(11) DEFAULT NULL,
  `bill_date` date DEFAULT NULL,
  `service_date` date DEFAULT NULL,
  `service_time` varchar(85) DEFAULT NULL,
  `service_charge` int(11) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `log_details`
--

CREATE TABLE `log_details` (
  `logid` int(11) NOT NULL,
  `user_name` varchar(150) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` varchar(85) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `medicine_categories`
--

CREATE TABLE `medicine_categories` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(150) DEFAULT NULL,
  `category_descp` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `medicine_details`
--

CREATE TABLE `medicine_details` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(150) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `units_in_stock` int(11) DEFAULT NULL,
  `unit_price` int(11) DEFAULT NULL,
  `reorder_level` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `order_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `order_details`
--

CREATE TABLE `order_details` (
  `order_detail_id` int(11) NOT NULL,
  `order_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `unit_price` int(11) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  `net_value` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `out_patients_treatments`
--

CREATE TABLE `out_patients_treatments` (
  `ophistory_id` int(11) NOT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` date DEFAULT NULL,
  `description` varchar(150) DEFAULT NULL,
  `prescription` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `patient_bill`
--

CREATE TABLE `patient_bill` (
  `patient_bill_id` int(11) NOT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `admission_id` int(11) DEFAULT NULL,
  `discharge_date` date DEFAULT NULL,
  `doctor_charges` int(11) DEFAULT NULL,
  `medicine_charges` int(11) DEFAULT NULL,
  `service_charges` int(11) DEFAULT NULL,
  `room_changes` int(11) DEFAULT NULL,
  `hospital_charges` int(11) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  `net_value` int(11) DEFAULT NULL,
  `other_bill_details` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `patient_bill_payment`
--

CREATE TABLE `patient_bill_payment` (
  `bill_payment_id` int(11) NOT NULL,
  `patientbill_id` int(11) DEFAULT NULL,
  `amount_paid` int(11) DEFAULT NULL,
  `paid_date` date DEFAULT NULL,
  `payment_type` varchar(85) DEFAULT NULL,
  `checkno` varchar(35) DEFAULT NULL,
  `checkdate` date DEFAULT NULL,
  `bank` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `patient_details`
--

CREATE TABLE `patient_details` (
  `patient_id` int(11) NOT NULL,
  `frist_name` varchar(150) DEFAULT NULL,
  `last_name` varchar(150) DEFAULT NULL,
  `gender` varchar(85) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `telephone` varchar(85) DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `prescription_details`
--

CREATE TABLE `prescription_details` (
  `prescription_id` int(11) NOT NULL,
  `medicine_service_id` int(11) DEFAULT NULL,
  `frequency` int(11) DEFAULT NULL,
  `no_of_days` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `purchase_orders`
--

CREATE TABLE `purchase_orders` (
  `purchase_order_id` int(11) NOT NULL,
  `purchase_supplier_id` int(11) DEFAULT NULL,
  `purchase_order_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `purchase_orde_details`
--

CREATE TABLE `purchase_orde_details` (
  `purchase_orde_dtlsid` int(11) NOT NULL,
  `purchase_orde_id` int(11) DEFAULT NULL,
  `purchase_orde_prodid` int(11) DEFAULT NULL,
  `purchase_quty` int(11) DEFAULT NULL,
  `purchase_unit_price` int(11) DEFAULT NULL,
  `purchase_deiscount` int(11) DEFAULT NULL,
  `net_value` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `room_booking`
--

CREATE TABLE `room_booking` (
  `patient_id` int(11) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  `description` char(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_booking`
--

INSERT INTO `room_booking` (`patient_id`, `room_id`, `description`) VALUES
(1, 1, 'dasdasd');

-- --------------------------------------------------------

--
-- Table structure for table `room_details`
--

CREATE TABLE `room_details` (
  `room_id` int(11) NOT NULL,
  `room_type` varchar(85) DEFAULT NULL,
  `room_description` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_details`
--

INSERT INTO `room_details` (`room_id`, `room_type`, `room_description`) VALUES
(1, 'Single', 'asdasd');

-- --------------------------------------------------------

--
-- Table structure for table `room_type`
--

CREATE TABLE `room_type` (
  `room_rates` int(11) NOT NULL,
  `notes` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE `service` (
  `channel_service_id` int(11) NOT NULL,
  `channel_service` varchar(150) DEFAULT NULL,
  `duration_of_service` int(11) DEFAULT NULL,
  `charge_for_service` int(11) DEFAULT NULL,
  `service_notes` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`channel_service_id`, `channel_service`, `duration_of_service`, `charge_for_service`, `service_notes`) VALUES
(1, 'asdasd', 1, 1, 'asdad');

-- --------------------------------------------------------

--
-- Table structure for table `service_appointment`
--

CREATE TABLE `service_appointment` (
  `appointment_id` int(11) NOT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `hospital_service_id` int(11) DEFAULT NULL,
  `appointment_date` date DEFAULT NULL,
  `appointment_time` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `service_appointment_bill`
--

CREATE TABLE `service_appointment_bill` (
  `appointment_bill_id` int(11) NOT NULL,
  `appointment_id` int(11) DEFAULT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `bill_date` date DEFAULT NULL,
  `appointment_charge` int(11) DEFAULT NULL,
  `hospital_charge` int(11) DEFAULT NULL,
  `grand_total` int(11) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  `net_value` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `service_appointment_bill_payment`
--

CREATE TABLE `service_appointment_bill_payment` (
  `bill_payment_id` int(11) NOT NULL,
  `appointment_bill_id` int(11) DEFAULT NULL,
  `amount_paid` int(11) DEFAULT NULL,
  `paid_date` date DEFAULT NULL,
  `payment_type` varchar(85) DEFAULT NULL,
  `checkno` varchar(85) DEFAULT NULL,
  `checkdate` date DEFAULT NULL,
  `bank` varchar(85) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `service_schedule_details`
--

CREATE TABLE `service_schedule_details` (
  `service_schedule_id` int(11) NOT NULL,
  `service_id` int(11) DEFAULT NULL,
  `service_starts` date DEFAULT NULL,
  `service_ends` date DEFAULT NULL,
  `service_avaidate` date DEFAULT NULL,
  `schedule_notes` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `slip`
--

CREATE TABLE `slip` (
  `ecode` int(11) NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  `dept` varchar(150) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `basic` int(11) DEFAULT NULL,
  `da` int(11) DEFAULT NULL,
  `hra` int(11) DEFAULT NULL,
  `cca` int(11) DEFAULT NULL,
  `trans` int(11) DEFAULT NULL,
  `gpf` int(11) DEFAULT NULL,
  `ins` int(11) DEFAULT NULL,
  `itax` int(11) DEFAULT NULL,
  `ptax` int(11) DEFAULT NULL,
  `gross` int(11) DEFAULT NULL,
  `deduct` int(11) DEFAULT NULL,
  `net` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE `suppliers` (
  `supplier_id` int(11) NOT NULL,
  `company_name` varchar(150) DEFAULT NULL,
  `contact_name` varchar(150) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(85) DEFAULT NULL,
  `fax` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

CREATE TABLE `user_details` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(150) DEFAULT NULL,
  `user_password` varchar(150) DEFAULT NULL,
  `user_type` varchar(85) DEFAULT NULL,
  `first_name` varchar(150) DEFAULT NULL,
  `last_name` varchar(150) DEFAULT NULL,
  `gender` varchar(85) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `telephone` varchar(85) DEFAULT NULL,
  `status` varchar(150) DEFAULT NULL,
  `notes` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `visit_details`
--

CREATE TABLE `visit_details` (
  `visit_id` int(11) NOT NULL,
  `visit_date` date DEFAULT NULL,
  `visit_time` varchar(85) DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `admission_id` int(11) DEFAULT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `prescription_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ward_details`
--

CREATE TABLE `ward_details` (
  `ward_id` int(11) NOT NULL,
  `ward_name` varchar(150) DEFAULT NULL,
  `ward_rate` int(11) DEFAULT NULL,
  `ward_desc` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admission_details`
--
ALTER TABLE `admission_details`
  ADD PRIMARY KEY (`admission_id`);

--
-- Indexes for table `appointment_bill`
--
ALTER TABLE `appointment_bill`
  ADD PRIMARY KEY (`appointment_bill_id`);

--
-- Indexes for table `appointment_bill_payment`
--
ALTER TABLE `appointment_bill_payment`
  ADD PRIMARY KEY (`bill_payment_id`);

--
-- Indexes for table `bad_details`
--
ALTER TABLE `bad_details`
  ADD PRIMARY KEY (`bed_id`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`dept_id`);

--
-- Indexes for table `department_details`
--
ALTER TABLE `department_details`
  ADD PRIMARY KEY (`department_id`);

--
-- Indexes for table `doctor_appointment`
--
ALTER TABLE `doctor_appointment`
  ADD PRIMARY KEY (`appointment_id`);

--
-- Indexes for table `doctor_dtls`
--
ALTER TABLE `doctor_dtls`
  ADD PRIMARY KEY (`doctor_id`);

--
-- Indexes for table `doctor_schedule`
--
ALTER TABLE `doctor_schedule`
  ADD PRIMARY KEY (`schedule_id`),
  ADD KEY `doctor_id` (`doctor_id`);

--
-- Indexes for table `doctor_schedule_details`
--
ALTER TABLE `doctor_schedule_details`
  ADD PRIMARY KEY (`schedule_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`emp_id`);

--
-- Indexes for table `employee_details`
--
ALTER TABLE `employee_details`
  ADD PRIMARY KEY (`employee_id`);

--
-- Indexes for table `employee_doctor_salary`
--
ALTER TABLE `employee_doctor_salary`
  ADD PRIMARY KEY (`doctor_salid`);

--
-- Indexes for table `employee_salary`
--
ALTER TABLE `employee_salary`
  ADD PRIMARY KEY (`salary_id`);

--
-- Indexes for table `guardian_details`
--
ALTER TABLE `guardian_details`
  ADD PRIMARY KEY (`guardian_id`);

--
-- Indexes for table `hospital_charges`
--
ALTER TABLE `hospital_charges`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hospital_details`
--
ALTER TABLE `hospital_details`
  ADD PRIMARY KEY (`hospital_id`);

--
-- Indexes for table `inpatient_orders`
--
ALTER TABLE `inpatient_orders`
  ADD PRIMARY KEY (`order_id`);

--
-- Indexes for table `inpatient_order_details`
--
ALTER TABLE `inpatient_order_details`
  ADD PRIMARY KEY (`order_details_id`);

--
-- Indexes for table `in_patient_details`
--
ALTER TABLE `in_patient_details`
  ADD PRIMARY KEY (`patient_id`);

--
-- Indexes for table `in_patient_detls`
--
ALTER TABLE `in_patient_detls`
  ADD PRIMARY KEY (`patient_id`);

--
-- Indexes for table `in_patient_discharge`
--
ALTER TABLE `in_patient_discharge`
  ADD PRIMARY KEY (`discharge_id`);

--
-- Indexes for table `in_patient_services`
--
ALTER TABLE `in_patient_services`
  ADD PRIMARY KEY (`inpatient_serviceid`);

--
-- Indexes for table `log_details`
--
ALTER TABLE `log_details`
  ADD PRIMARY KEY (`logid`);

--
-- Indexes for table `medicine_categories`
--
ALTER TABLE `medicine_categories`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `medicine_details`
--
ALTER TABLE `medicine_details`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`);

--
-- Indexes for table `order_details`
--
ALTER TABLE `order_details`
  ADD PRIMARY KEY (`order_detail_id`);

--
-- Indexes for table `out_patients_treatments`
--
ALTER TABLE `out_patients_treatments`
  ADD PRIMARY KEY (`ophistory_id`);

--
-- Indexes for table `patient_bill`
--
ALTER TABLE `patient_bill`
  ADD PRIMARY KEY (`patient_bill_id`);

--
-- Indexes for table `patient_bill_payment`
--
ALTER TABLE `patient_bill_payment`
  ADD PRIMARY KEY (`bill_payment_id`);

--
-- Indexes for table `patient_details`
--
ALTER TABLE `patient_details`
  ADD PRIMARY KEY (`patient_id`);

--
-- Indexes for table `prescription_details`
--
ALTER TABLE `prescription_details`
  ADD PRIMARY KEY (`prescription_id`);

--
-- Indexes for table `purchase_orders`
--
ALTER TABLE `purchase_orders`
  ADD PRIMARY KEY (`purchase_order_id`);

--
-- Indexes for table `purchase_orde_details`
--
ALTER TABLE `purchase_orde_details`
  ADD PRIMARY KEY (`purchase_orde_dtlsid`);

--
-- Indexes for table `room_details`
--
ALTER TABLE `room_details`
  ADD PRIMARY KEY (`room_id`);

--
-- Indexes for table `room_type`
--
ALTER TABLE `room_type`
  ADD PRIMARY KEY (`room_rates`);

--
-- Indexes for table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`channel_service_id`);

--
-- Indexes for table `service_appointment`
--
ALTER TABLE `service_appointment`
  ADD PRIMARY KEY (`appointment_id`);

--
-- Indexes for table `service_appointment_bill`
--
ALTER TABLE `service_appointment_bill`
  ADD PRIMARY KEY (`appointment_bill_id`);

--
-- Indexes for table `service_appointment_bill_payment`
--
ALTER TABLE `service_appointment_bill_payment`
  ADD PRIMARY KEY (`bill_payment_id`);

--
-- Indexes for table `service_schedule_details`
--
ALTER TABLE `service_schedule_details`
  ADD PRIMARY KEY (`service_schedule_id`);

--
-- Indexes for table `slip`
--
ALTER TABLE `slip`
  ADD PRIMARY KEY (`ecode`);

--
-- Indexes for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`supplier_id`);

--
-- Indexes for table `user_details`
--
ALTER TABLE `user_details`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `visit_details`
--
ALTER TABLE `visit_details`
  ADD PRIMARY KEY (`visit_id`);

--
-- Indexes for table `ward_details`
--
ALTER TABLE `ward_details`
  ADD PRIMARY KEY (`ward_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admission_details`
--
ALTER TABLE `admission_details`
  MODIFY `admission_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `appointment_bill_payment`
--
ALTER TABLE `appointment_bill_payment`
  MODIFY `bill_payment_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `doctor_dtls`
--
ALTER TABLE `doctor_dtls`
  MODIFY `doctor_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `doctor_schedule`
--
ALTER TABLE `doctor_schedule`
  MODIFY `schedule_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `guardian_details`
--
ALTER TABLE `guardian_details`
  MODIFY `guardian_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `inpatient_order_details`
--
ALTER TABLE `inpatient_order_details`
  MODIFY `order_details_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `in_patient_details`
--
ALTER TABLE `in_patient_details`
  MODIFY `patient_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `out_patients_treatments`
--
ALTER TABLE `out_patients_treatments`
  MODIFY `ophistory_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `patient_details`
--
ALTER TABLE `patient_details`
  MODIFY `patient_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `prescription_details`
--
ALTER TABLE `prescription_details`
  MODIFY `prescription_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `service`
--
ALTER TABLE `service`
  MODIFY `channel_service_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `service_appointment`
--
ALTER TABLE `service_appointment`
  MODIFY `appointment_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `service_appointment_bill`
--
ALTER TABLE `service_appointment_bill`
  MODIFY `appointment_bill_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `service_appointment_bill_payment`
--
ALTER TABLE `service_appointment_bill_payment`
  MODIFY `bill_payment_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `service_schedule_details`
--
ALTER TABLE `service_schedule_details`
  MODIFY `service_schedule_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `doctor_schedule`
--
ALTER TABLE `doctor_schedule`
  ADD CONSTRAINT `doctor_schedule_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `doctor_dtls` (`doctor_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
