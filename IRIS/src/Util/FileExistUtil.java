/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.io.File;

/**
 *
 * @author akshatajadhav
 */
public class FileExistUtil {
    static public boolean isVideoFileExists(String filename){
        File f = new File("video\\"+filename+".flv");
        return f.exists();            
    }
}
