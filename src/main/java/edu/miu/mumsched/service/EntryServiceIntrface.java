package edu.miu.mumsched.service;

import edu.miu.mumsched.domain.Entry;

import java.util.List;

public interface EntryServiceIntrface {
    public void save(Entry entry);
    public Entry getEntryById(int entryId);
    public Entry getEntryByName(String entryName);
    public List<Entry> getAllEntry();

}
