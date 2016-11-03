package edu.up.cs371.soccer_application;

import android.content.Context;
import android.util.Log;

import edu.up.cs371.soccer_application.soccerPlayer.SoccerPlayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Soccer player database -- presently, all dummied up
 *
 * @author *** put your name here ***
 * @version *** put date of completion here ***
 */
public class SoccerDatabase implements SoccerDB {

    Hashtable<String, SoccerPlayer> table = new Hashtable<String, SoccerPlayer>();
    SoccerPlayer temp;

    /**
     * add a player
     *
     * @see SoccerDB#addPlayer(String, String, int, String)
     */
    @Override
    public boolean addPlayer(String firstName, String lastName,
                             int uniformNumber, String teamName) {
        String fullName = firstName + " ## " + lastName;
        if (table.get(fullName) != null) {
            return false;
        } else {
            SoccerPlayer p = new SoccerPlayer(firstName, lastName, uniformNumber, teamName);
            table.put(fullName, p);
            return true;
        }


    }

    /**
     * remove a player
     *
     * @see SoccerDB#removePlayer(String, String)
     */
    @Override
    public boolean removePlayer(String firstName, String lastName) {
        String fullName = firstName + " ## " + lastName;
        if (table.get(fullName) == null) {
            return false;
        } else {
            table.remove(fullName);
            return true;
        }
    }

    /**
     * look up a player
     *
     * @see SoccerDB#getPlayer(String, String)
     */
    @Override
    public SoccerPlayer getPlayer(String firstName, String lastName) {
        String fullName = firstName + " ## " + lastName;
        if (table.get(fullName) == null) {
            return null;
        } else {
            return table.get(fullName);
        }

    }

    /**
     * increment a player's goals
     *
     * @see SoccerDB#bumpGoals(String, String)
     */
    @Override
    public boolean bumpGoals(String firstName, String lastName) {
        String fullName = firstName + " ## " + lastName;
        if (table.get(fullName) == null) {
            return false;
        } else {
            temp = table.get(fullName);
            temp.bumpGoals();
            return true;
        }

    }

    /**
     * increment a player's assists
     *
     * @see SoccerDB#bumpAssists(String, String)
     */
    @Override
    public boolean bumpAssists(String firstName, String lastName) {
        String fullName = firstName + " ## " + lastName;
        if (table.get(fullName) == null) {
            return false;
        } else {
            temp = table.get(fullName);
            temp.bumpAssists();
            return true;
        }
    }

    /**
     * increment a player's shots
     *
     * @see SoccerDB#bumpShots(String, String)
     */
    @Override
    public boolean bumpShots(String firstName, String lastName) {
        String fullName = firstName + " ## " + lastName;
        if (table.get(fullName) == null) {
            return false;
        } else {
            temp = table.get(fullName);
            temp.bumpShots();
            return true;
        }
    }

    /**
     * increment a player's saves
     *
     * @see SoccerDB#bumpSaves(String, String)
     */
    @Override
    public boolean bumpSaves(String firstName, String lastName) {
        String fullName = firstName + " ## " + lastName;
        if (table.get(fullName) == null) {
            return false;
        } else {
            temp = table.get(fullName);
            temp.bumpSaves();
            return true;
        }
    }

    /**
     * increment a player's fouls
     *
     * @see SoccerDB#bumpFouls(String, String)
     */
    @Override
    public boolean bumpFouls(String firstName, String lastName) {
        String fullName = firstName + " ## " + lastName;
        if (table.get(fullName) == null) {
            return false;
        } else {
            temp = table.get(fullName);
            temp.bumpFouls();
            return true;
        }
    }

    /**
     * increment a player's yellow cards
     *
     * @see SoccerDB#bumpYellowCards(String, String)
     */
    @Override
    public boolean bumpYellowCards(String firstName, String lastName) {
        String fullName = firstName + " ## " + lastName;
        if (table.get(fullName) == null) {
            return false;
        } else {
            temp = table.get(fullName);
            temp.bumpYellowCards();
            return true;
        }
    }

    /**
     * increment a player's red cards
     *
     * @see SoccerDB#bumpRedCards(String, String)
     */
    @Override
    public boolean bumpRedCards(String firstName, String lastName) {
        String fullName = firstName + " ## " + lastName;
        if (table.get(fullName) == null) {
            return false;
        } else {
            temp = table.get(fullName);
            temp.bumpRedCards();
            return true;
        }
    }

    /**
     * tells the number of players on a given team
     *
     * @see SoccerDB#numPlayers(String)
     */
    @Override
    // report number of players on a given team (or all players, if null)
    public int numPlayers(String teamName) {
        int count = 0;
        if (teamName == null) {
            count = table.size();
        } else {
            for (String key : table.keySet()) {
                if (table.get(key).getTeamName().equals(teamName)) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * gives the nth player on a the given team
     *
     * @see SoccerDB#playerNum(int, String)
     */
    // get the nTH player
    @Override
    public SoccerPlayer playerNum(int idx, String teamName) {
        int count = 0;
        SoccerPlayer[] team = new SoccerPlayer[100];
        if (teamName == null) {
            for (String key : table.keySet()) {
                team[count] = table.get(key);
                count++;
            }
        } else {
            for (String key : table.keySet()) {
                if (table.get(key).getTeamName().equals(teamName)) {
                    team[count] = table.get(key);
                    count++;
                }
            }
        }
        return team[idx];

    }

    /**
     * reads database data from a file
     *
     * @see SoccerDB#readData(java.io.File)
     */
    // read data from file
    @Override
    public boolean readData(File file) {

        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNext()) {
                String firstName = sc.nextLine();
                String lastName = sc.nextLine();
                String teamName = sc.nextLine();
                if(sc.hasNext()) {
                    String uniform = sc.nextLine();
                }
                //addPlayer(firstName, lastName, uniform, teamName);

            }
            sc.close();
        } catch (FileNotFoundException e) {
            //
        }


       return file.exists();
    }

    /**
     * write database data to a file
     *
     * @see SoccerDB#writeData(java.io.File)
     */
    // write data to file
    @Override
    public boolean writeData(File file) {
        SoccerPlayer t1;
        try {
            PrintWriter pw = new PrintWriter(file);
            pw.println(logString("Skip"));
        } catch (FileNotFoundException e) {
            //
        }
        for (String key : table.keySet()) {
            t1 = table.get(key);
                try {
                    PrintWriter pw = new PrintWriter(file);

                    pw.println(logString(t1.getFirstName()));
                    pw.println(logString(t1.getLastName()));
                    pw.println(logString(t1.getTeamName()));
                    pw.println(logString("" + t1.getUniform()));
                    pw.println(logString("" + t1.getGoals()));
                    pw.println(logString("" + t1.getAssists()));
                    pw.println(logString("" + t1.getShots()));
                    pw.println(logString("" + t1.getSaves()));
                    pw.println(logString("" + t1.getFouls()));
                    pw.println(logString("" + t1.getYellowCards()));
                    pw.println(logString("" + t1.getRedCards()));
                    pw.close();
                } catch (FileNotFoundException e) {
                    //

            }
        }

            return true;

    }


    /**
     * helper method that logcat-logs a string, and then returns the string.
     *
     * @param s the string to log
     * @return the string s, unchanged
     */
    private String logString(String s) {
        Log.i("write string", s);
        return s;
    }

    /**
     * returns the list of team names in the database
     *
     * @see edu.up.cs371.soccer_application.SoccerDB#getTeams()
     */
    // return list of teams
    @Override
    public HashSet<String> getTeams() {
        return new HashSet<String>();
    }

}
