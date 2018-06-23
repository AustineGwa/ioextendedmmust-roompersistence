package com.austinegwa64.newfriends.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by gwaza on 6/23/2018.
 */

@Dao
public interface DatabaseDao {

    @Query("SELECT * FROM myFriends")
    List<Friend> getAllFriends();

    @Insert
    void insertAll(Friend... friends);

}
