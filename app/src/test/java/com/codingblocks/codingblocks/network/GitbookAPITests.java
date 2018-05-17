package com.codingblocks.codingblocks.network;

import com.codingblocks.codingblocks.models.AuthorBooksCB;
import com.codingblocks.codingblocks.network.interfaces.GitbookAPI;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.*;

public class GitbookAPITests {

    static Retrofit retrofit;
    static GitbookAPI gitbookAPI;

    @BeforeClass
    public static void setupRetrofit () {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.gitbook.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        gitbookAPI = retrofit.create(GitbookAPI.class);
    }

    @Test
    public void testGetAllBooks () throws Exception {
        AuthorBooksCB authorBooks = gitbookAPI.getAllBooks().execute().body();
        assertNotNull(authorBooks);
        assertEquals(3, (long) authorBooks.getTotal());
    }

}
