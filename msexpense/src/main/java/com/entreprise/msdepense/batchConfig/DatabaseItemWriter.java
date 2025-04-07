package com.entreprise.msdepense.batchConfig;

import com.entreprise.msdepense.entities.Depense;
import com.entreprise.msdepense.repositories.DepenseRepository;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseItemWriter implements ItemWriter<Depense> {

    @Autowired
    private DepenseRepository depenseRepository;

    @Override
    public void write(Chunk<? extends Depense> chunk) throws Exception{
        depenseRepository.saveAll(chunk.getItems());
    }
}
