package com.example.jobquest.repository;

import java.util.*;
import com.example.jobquest.model.*;
import com.example.jobquest.dto.*;

public interface ApplicationRepository {
    // List<Application> getApplications();
    List<ApplicationResponse> getApplicationsByJobId(int jobid);

    List<ApplicationResponse> getApplicationsByUserId(int id);

    JobResponse getApplicationStats(int jobId);

    ApplicationResponse applyToAJob(Application a);

    ApplicationResponse modifyApplicationStatus (int id, String s);

    List<ApplicationResponse> bulkUpdateApplicationStatus (BulkStatusUpdateRequest r);

    void deleteUserApplication (int id);
}
