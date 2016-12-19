package Entities;


import java.util.ArrayList;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rymlarayedh
 */
public class Report {
    private int reportid;
    int tripid;
    int reporteduserid;
    int userid;
       
            
            public Report() {
        }
        
        public Report(int tripid,int reporteduserid, int UserId) {
            this.tripid=tripid;
            this.reporteduserid = reporteduserid;
            this.reportid = reportid;
        }

    public int getReportid() {
        return reportid;
    }

    public void setReportid(int reportid) {
        this.reportid = reportid;
    }

    public int getTripid() {
        return tripid;
    }

    public void setTripid(int tripid) {
        this.tripid = tripid;
    }

    public int getReporteduserid() {
        return reporteduserid;
    }

    public void setReporteduserid(int reporteduserid) {
        this.reporteduserid = reporteduserid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Report other = (Report) obj;
        if (this.reportid != other.reportid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Report{" + "reportid=" + reportid + ", tripid=" + tripid + ", reporteduserid=" + reporteduserid + ", userid=" + userid + '}';
    }
        
        
        
    }

    

