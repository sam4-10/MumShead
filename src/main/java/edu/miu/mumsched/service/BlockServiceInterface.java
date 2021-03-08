package edu.miu.mumsched.service;

import edu.miu.mumsched.domain.Block;
import edu.miu.mumsched.domain.Entry;

import java.util.List;

public interface BlockServiceInterface {

    public void save(Block block);
    public Block getBlockById(int blockId);
    public Block getBlockByName(String blockName);
    public List<Block> getAllBlock();
}
