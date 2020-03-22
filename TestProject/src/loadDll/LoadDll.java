/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadDll;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 *
 * @author VSI-ANIK
 */
public interface LoadDll extends Library{
    LoadDll INSTANT =(LoadDll)Native.loadLibrary("libs\\zkemkeeper",LoadDll.class);
    public void OnConnected(long mNum);
}
