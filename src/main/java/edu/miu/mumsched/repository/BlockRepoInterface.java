package edu.miu.mumsched.repository;

import edu.miu.mumsched.domain.Block;
import edu.miu.mumsched.domain.Entry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockRepoInterface extends CrudRepository<Block,Long> {

    @Query("select s from Block s where s.blockId=:blockId")
    public Block findByBlockId(@Param("blockId")int blockId);

    @Query("select s from Block s where s.blockName=:blockName")
    public Block findByBlockName(@Param("blockName")String blockName);

    @Query("select s from Block s")
    public List<Block> getAllBlocks();
}
