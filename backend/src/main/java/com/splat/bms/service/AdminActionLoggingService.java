package com.splat.bms.service;

public interface AdminActionLoggingService {

    /**
     * Logs a new admin action
     *
     * @param bannerId    int target banner id
     * @param adminId     int admin id
     * @param description string description of action
     */
    void log(int adminId, int bannerId, String description);

}
