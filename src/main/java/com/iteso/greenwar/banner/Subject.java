package com.iteso.greenwar.banner;

/**
 * This abstract class is implementing the
 * Singleton pattern for managing game results.
 * Created with IntelliJ IDEA.
 * @author: jortiz
 * @version: 09/04/2020/1.0
 */
public interface Subject {
    /**
     * Method used to registed new highest scores.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     * @param observer The observer
     */
    void startRegisterRecords(Observer observer);
    /**
     * Method to record new highest scores.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     * @param observer The observer
     */
    void finishRegisterRecords(Observer observer);
    /**
     * Method that notifies about newly registered
     * highest scores.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     */
    void notifyRegisterRecords();
}
