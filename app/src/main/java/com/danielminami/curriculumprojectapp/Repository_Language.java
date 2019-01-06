package com.danielminami.curriculumprojectapp;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Repository_Language {

    @GET("/language/list")
    Call<List<Model_Language>> getAllModel_Language();
}
