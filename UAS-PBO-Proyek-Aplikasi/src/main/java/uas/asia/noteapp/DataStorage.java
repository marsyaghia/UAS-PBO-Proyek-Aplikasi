/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uas.asia.noteapp;

import java.util.List;

/**
 *
 * @author devinta
 */

/* 
* ini interface, yang manggil interface 
* ini harus membuat fungsi yang ada pada interface (writeData, readData, deleteData)
*/
public interface DataStorage {
    
    void writeData(String note);

    List<String> readData();

    void deleteData(String note);
}