package org.nwolfhub.db;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class DBActions {
    private static List<Wrestler> wrestlers;
    public static void InitializeWrestlingDb() {
        wrestlers = new ArrayList<>();
        File wweBase = new File("wwe.base");
        if(wweBase.exists()) {
            try {
                String baseContent = new String(Files.readAllBytes(wweBase.toPath())).replace("\n", "").replace("\t", "");
                String[] wrestlersPlain = baseContent.split(";");
                for (String wrestler : wrestlersPlain) {
                    String[] splitted = wrestler.split("\\$");
                    addWrestler(splitted[0], splitted[1]);
                }
                System.out.println("Wrestlers are in DB now!");
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        } else {
            System.out.println("Cannot find wwe.base! Please restart bot and make sure that wwe.base is a valid file in " + System.getProperty("user.dir"));
            System.exit(404);
        }
    }
    private static void addWrestler(String name, String photo) {
        wrestlers.add(new Wrestler(name, photo));
    }
    public static List<Wrestler> searchWrestlers(String providedName) {
        List<Wrestler> resultList = new ArrayList<>();
        for (Wrestler wrestler : wrestlers) {
            if(wrestler.getName().toLowerCase(Locale.ROOT).replace(" ", "").equals(providedName.toLowerCase(Locale.ROOT).replace(" ", ""))) {resultList.add(wrestler);}
        }
        return resultList;
    }
}
