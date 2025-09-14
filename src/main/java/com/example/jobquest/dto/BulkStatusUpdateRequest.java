package com.example.jobquest.dto;

import java.util.*;
import com.example.jobquest.model.Application;

public class BulkStatusUpdateRequest {

    private List<ApplicationStatusUpdates> updatesList;

    public List<ApplicationStatusUpdates> getUpdatesList(){
        return updatesList;
    }

    public void setUpdatesList(List<ApplicationStatusUpdates> updatesList){
        this.updatesList = updatesList;
    }

    public static class ApplicationStatusUpdates {
        private int applicationId;
        private Application.Status status;

        public int getApplicationId() {
            return applicationId;
        }

        public void setApplicationId(int applicationId) {
            this.applicationId = applicationId;
        }

        public Application.Status getStatus() {
            return status;
        }

        public void setStatus(Application.Status status) {
            this.status = status;
        }
    }

}

