package edu.miu.mumsched.serviceImpl;

import edu.miu.mumsched.domain.Block;
import edu.miu.mumsched.repository.BlockRepoInterface;
import edu.miu.mumsched.service.BlockServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockServiceImpl implements BlockServiceInterface {

    @Autowired
    BlockRepoInterface blockRepoInterface;
    @Override
    public void save(Block block) {
        blockRepoInterface.save(block);
    }

    @Override
    public Block getBlockById(int blockId) {
        return blockRepoInterface.findByBlockId(blockId);
    }

    @Override
    public Block getBlockByName(String blockName) {
        return blockRepoInterface.findByBlockName(blockName);
    }

    @Override
    public List<Block> getAllBlock() {
        return blockRepoInterface.getAllBlocks();
    }
}
