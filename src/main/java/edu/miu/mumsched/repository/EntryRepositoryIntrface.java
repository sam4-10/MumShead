package edu.miu.mumsched.repository;

import edu.miu.mumsched.domain.Entry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepositoryIntrface extends CrudRepository<Entry,Long> {
      @Query("select s from Entry s where s.entryId=:entryId")
    public Entry findByEntryId(@Param("entryId")int entryId);

    @Query("select s from Entry s where s.entryName=:entryName")
    public Entry findByEntryName(@Param("entryName")String entryName);

@Query("select s from Entry s")
    public List<Entry> getAllEntry();
}
