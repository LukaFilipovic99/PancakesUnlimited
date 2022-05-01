package com.lukafilipovic.PancakesUnlimitedApp.payload.Response;

import lombok.Data;


public interface ReportResponse {
    long getId();
    String getName();
    int getTimesOrdered();
}
