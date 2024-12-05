package com.example.seminar4_;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AutocareDAO {

        @Insert
        public void inserareAutocar(Autocar autocar);

        @Query("Select * from Autocare")
        public List<Autocar> getAllAutocar();

        @Delete
        void deleteAutocar(Autocar autocar);

}
