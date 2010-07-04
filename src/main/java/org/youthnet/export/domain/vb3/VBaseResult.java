package org.youthnet.export.domain.vb3;


import java.util.Date;


public class VBaseResult {
}


    private String resultMessage;
    private RESULT result;
    private Date databaseDate;


    public VBaseResult() {
    }


    public VBaseResult(RESULT result, String resultMessage, Date databaseDate) {
        this.resultMessage = resultMessage;
        this.result = result;
        this.databaseDate = databaseDate;
    }


    public String getResultMessage() {
    }


    public RESULT getResult() {
    }


    public Date getDatabaseDate() {
    }


    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }


    public void setResult(RESULT result) {
        this.result = result;
    }


    public void setDatabaseDate(Date databaseDate) {
        this.databaseDate = databaseDate;
    }
}
