package com.sarthak.student_api.exception;


import java.time.LocalDateTime;

public class ErrorResponse {
   private int status;
   private String message;
   private LocalDateTime timestamp;

   public ErrorResponse(int status,String message){
       this.message = message;
       this.status = status;
       this.timestamp = LocalDateTime.now();
   }

   //getter
    public int getStatus(){
       return status;
    }
    public String  getMessage(){return message;}
    public LocalDateTime getTimestamp(){return  timestamp;}
}
