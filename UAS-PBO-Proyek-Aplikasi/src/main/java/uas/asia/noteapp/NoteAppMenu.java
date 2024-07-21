/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas.asia.noteapp;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author budi
 */
public class NoteAppMenu {
    private NoteService noteService;
    private Scanner scanner;

    public NoteAppMenu(String databasePath) {
        noteService = new NoteService(new DatabaseStorage(databasePath));
        scanner = new Scanner(System.in);
    }
    
    // ini dikerjakan pertama buat manggil fungsi menu
    public void start(){
        menu();
//        addNote();
//        showNotes();
    }
    
    // ini untuk input menu 1 - 4
    public static String pilihMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pilih nomor menu (1 - 4) : ");
        String input = scanner.nextLine();
        return input;
    }
    
    // ini untuk list menu 
    private void menu(){
        boolean boole = true;
            while(boole){
                System.out.println(" ");
                System.out.println("Aplikasi menu nota. Oleh : Devinta Irma Santi,  NIM : 23201298");
                System.out.println("1. Tambahkan Nota");
                System.out.println("2. Tampilkan Data Nota");
                System.out.println("3. Hapus Nota");
                System.out.println("4. Keluar");
                System.out.println(" ");
                String pilihan = pilihMenu();

                switch (pilihan){
                case "1":
                    addNote();
                    break;
                case "2":
                    showNotes();
                    break;
                case "3":
                    deleteNote();
                    break;
                case "4":
                    boole = false;
                    break;
                default:
                    System.out.println("Pilihan tidak ada.");  
            }
        }
    }
    
    // ini fungsi untuk menambah nota
    private void addNote() {
        System.out.println("");
        System.out.println("Anda akan menambahkan data nota");
        System.out.print("Masukkan nota: ");
        String notabaru = scanner.nextLine();
        noteService.createNote(notabaru);
        System.out.println("Nota berhasil disimpan: " + notabaru);
    }
    
    // ini untuk menampilkan semua data nota
    private void showNotes() {
        List<String> notes = noteService.readNotes();
        System.out.println("");
        System.out.println("Note tersimpan:");
        if (notes.isEmpty()) {
            System.out.println("Tidak ada nota ditemukan.");
        } else {
            for (String note : notes) {
                System.out.println(note);
            }
        }
    }
    
    // ini untuk hapus data nota 1 per 1
    private void deleteNote(){
        List<String> dataNota = noteService.readNotes();
        System.out.println("");
        System.out.println("Anda akan menghapus data nota");
        System.out.println("List data nota : ");
        if(dataNota.isEmpty()){
            System.out.println("Data nota kosong");
        }else{
            for(String note : dataNota){
                System.out.println(note);
            }
            
            System.out.println("");
            int noteC = noteService.getNoteCount();
            String noteDipilih = noteService.getNoteByIndex(noteC-1);
            noteService.deleteNote(noteDipilih);
            System.out.println("Nota " + noteDipilih + " berhasil dihapus.");
            
        }
    }
}