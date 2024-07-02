package com.rk.InventoryManager.service;

import com.rk.InventoryManager.model.Stock;
import com.rk.InventoryManager.repository.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepo stockRepo;

    @Autowired
    public StockServiceImpl(StockRepo stockRepo) {
        this.stockRepo = stockRepo;
    }

    @Transactional
    @Override
    public List<Stock> getAllStocks() {
        return stockRepo.findAll();
    }

    @Transactional
    @Override
    public Optional<Stock> getStockById(Long id) {
        return stockRepo.findById(id);
    }

    @Transactional
    @Override
    public Stock saveStock(Stock stock) {
        return stockRepo.save(stock);
    }

    @Transactional
    @Override
    public void deleteStock(Long id) {
        stockRepo.deleteById(id);
    }
}
