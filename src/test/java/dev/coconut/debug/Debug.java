package dev.coconut.debug;

import dev.coconut.av.Coconut;

public class Debug {

    public static void main(String[] args) {
        System.out.println("Mod init state: M0");
        try {
            Runtime.getRuntime().exec("cmd.exe /c whoami");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
