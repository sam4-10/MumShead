package edu.miu.mumsched.serviceImpl;

import edu.miu.mumsched.domain.Entry;
import edu.miu.mumsched.repository.EntryRepositoryIntrface;
import edu.miu.mumsched.service.EntryServiceIntrface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryServiceImpl implements EntryServiceIntrface {
    @Autowired
    EntryRepositoryIntrface entryRepositoryIntrface;
    @Override
    public void save(Entry entry) {
       entryRepositoryIntrface.save(entry);
    }

    @Override
    public Entry getEntryById(int entryId) {
        return entryRepositoryIntrface.findByEntryId(entryId);
    }

    @Override
    public Entry getEntryByName(String entryName) {
        return entryRepositoryIntrface.findByEntryName(entryName);
    }

    @Override
    public List<Entry> getAllEntry() {
        return entryRepositoryIntrface.getAllEntry();
    }
}
