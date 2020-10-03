
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vsi.mail;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

/**
 *
 * @author VSI-ANIK
 */
public class MailSend {

    /**
     * Set user Mail & Password. note: please ensure that your mail account
     * security events must be active [ Access allowed for less secure apps ]
     *
     * for active this option you go to your google account then goto =>
     * security then goto => Recent security events then goto => Less secure app
     * access See in down [ Turn on it ]. Otherwise you can get a error is [
     * javax.mail.AuthenticationFailedException: 535-5.7.8 Username and Password
     * not accepted. ]
     */
    private static final String username = "engr.mahitul.cse1@gmail.com";
    private static final String password = "ieb@19_12@";
    private static final String reciverMailAddress = "care.vistasoft@gmail.com";

    // Main Function throws InterruptedException
    public static void main(String[] args) throws InterruptedException {

        while (true) {

            /**
             * Properties class helps us to set properties of mail server like
             * as mail STMP server name "smtp.gmail.com" like as mail STMP
             * server port number "587" like as active mail STMP server
             * authentication system like as active TLS.
             */
            Properties props = new Properties();
            props.put("mail.smtp.auth", true); // put server authentication system active
            props.put("mail.smtp.starttls.enable", true); // put Transport Layer Security active
            props.put("mail.smtp.host", "smtp.gmail.com"); // put STMP server host address
            props.put("mail.smtp.port", "587"); // put STMP server port number

            /**
             * Session object helps us connection with java mail API and it
             * provide mail configuration setting and authentication.
             *
             * getInstance(Properties,Authentication) this method helps us to
             * get user_defied mail session and authentication.
             */
            Session session = Session.getInstance(
                    props, // set mail propertices
                    // get aunthenticator object
                    new javax.mail.Authenticator() {
                /**
                 * Override getPasswordAuthentication() method and we put our
                 * mail address with password for get Authentication from mail
                 * server.
                 */
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            
            

            String folderPath = "D:\\MailSendingFile\\"; // write file folder path
            File connectFolder = new File(folderPath); // connect with folder location
            File[] fileList = connectFolder.listFiles(); // get file list from folder.
            // date formater for format the date using given format 
            SimpleDateFormat format = new SimpleDateFormat("MMddyyyy");
            // get system current date
            Date date = new Date(System.currentTimeMillis());
            // formated curren date
            String systemDate = format.format(date);
            System.out.println("System Date: " + systemDate);

            /**
             * This loop check file name and try to match file modified date
             * with system date.
             *
             * loop will working until find match file or end of file list.
             */
            for (File singleFile : fileList) {
                // get selected file modified date
                date = new Date(singleFile.lastModified());
                // format the file modefied date
                String fileModifiedDate = format.format(date);
                System.out.println("File Date: " + fileModifiedDate);

                /**
                 * Check weather for match any file with current date. if any
                 * file match with current date then send mail.
                 */
                if (systemDate.equals(fileModifiedDate)) {
                    // Make file name with location
                    String fileName = singleFile.getName();
                    System.out.println("Found File Name Is: " + fileName);
                    try {
                        // create a message box
                        Message message = new MimeMessage(session);
                        // set sender mail address
                        message.setFrom(new InternetAddress(username));
                        // set reciver mail address
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reciverMailAddress));
                        // set the subject of mail
                        message.setSubject("Testing Subject");
                        // set the mail body text
                        message.setText("PFA");
                        // create a message body
                        MimeBodyPart messageBodyPart = new MimeBodyPart();
                        // create Multipart object for add file in mail
                        Multipart multipart = new MimeMultipart();
                        // set file path
                        String filePath = folderPath + fileName;
                        // make a source object and get file from folder
                        DataSource source = new FileDataSource(filePath);
                        // Datahandler for upload file in mail server
                        messageBodyPart.setDataHandler(new DataHandler(source));
                        // set file in message body
                        messageBodyPart.setFileName(fileName);
                        // add attech in massage
                        multipart.addBodyPart(messageBodyPart);
                        // set message content
                        message.setContent(multipart);

                        System.out.println("Sending");
                        // send message using STMP to mail server
                        Transport.send(message);

                        System.out.println("Done");
                        // if file was send then delete item
                        singleFile.deleteOnExit();
                        System.exit(0);
                    } catch (MessagingException e) {
                        e.printStackTrace();
                        System.exit(0);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "NO data in date",
                    ":: SQL Error :: ", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            Thread.sleep(10000);
        }

    }

}
