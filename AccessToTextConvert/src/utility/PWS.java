/*
 * Copyright (C) 2020 VSI-ANIK
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package utility;

/**
 *
 * @author VSI-ANIK
 */
public class PWS implements PasswordEnqDnq {

    @Override
    public String passwordEnq(String planPass) {
        
        String finalStr="";
        int lngSize = planPass.length();
        System.out.println(planPass);
        
        for (int i = 0; i < lngSize; i++) {
            int tempAnsii =(int)planPass.charAt(i);
            tempAnsii += 2;
            char tempChar=(char) tempAnsii;
            System.out.println(tempChar);
            finalStr+=tempChar;
        }
        System.out.println(finalStr);
        return finalStr;
    }

    @Override
    public String passwordDnq(String planPass) {
        
        String finalStr="";
        System.out.println(planPass);
        int lngSize=planPass.length();
        
        for(int i=0;i<lngSize;i++){
            int tempAnsii =(int)planPass.charAt(i);
            tempAnsii -= 2;
            char tempChar=(char) tempAnsii;
            System.out.println(tempChar);
            finalStr+=tempChar;
        }
        System.out.println(finalStr);
        return finalStr;
    }

}
