package com.example.springMVC.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.springMVC.model.Beer;
import com.example.springMVC.model.BeerStyle;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    private Map<UUID, Beer> beerMap;

    public BeerServiceImpl(){

        this.beerMap = new HashMap<>();

        Beer beer1 = Beer.builder()
        .id(UUID.randomUUID())
        .version(1)
        .beerName("ABC")
        .beerStyle(BeerStyle.ALE)
        .upc("1234")
        .price(new BigDecimal("12.33"))
        .quanityOnHand(122)
        .createdDate(LocalDateTime.now())
        .updateDate(LocalDateTime.now())
        .build();

        Beer beer2 = Beer.builder()
        .id(UUID.randomUUID())
        .version(2)
        .beerName("XYZ")
        .beerStyle(BeerStyle.ALE)
        .upc("1234")
        .price(new BigDecimal("1.33"))
        .quanityOnHand(122)
        .createdDate(LocalDateTime.now())
        .updateDate(LocalDateTime.now())
        .build();

        Beer beer3 = Beer.builder()
        .id(UUID.randomUUID())
        .version(3)
        .beerName("UIO")
        .beerStyle(BeerStyle.ALE)
        .upc("1234")
        .price(new BigDecimal("22.33"))
        .quanityOnHand(33)
        .createdDate(LocalDateTime.now())
        .updateDate(LocalDateTime.now())
        .build();

        beerMap.put(beer1.getId(), beer1);
        beerMap.put(beer2.getId(), beer2);
        beerMap.put(beer3.getId(), beer3);
    }
    
    @Override
    public List<Beer> listBeers(){
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public Beer saveNewBeer(Beer beer){
        Beer savedBeer = Beer.builder()
                        .id(UUID.randomUUID())
                        .version(beer.getVersion())
                        .createdDate(LocalDateTime.now())
                        .updateDate(LocalDateTime.now())
                        .beerName(beer.getBeerName())
                        .beerStyle(beer.getBeerStyle())
                        .quanityOnHand(beer.getQuanityOnHand())
                        .upc(beer.getUpc())
                        .price(beer.getPrice())
                        .build();

        beerMap.put(savedBeer.getId(), savedBeer);
        return savedBeer;
    }


    
    @Override
    public Beer getBeerById(UUID id) {

        log.debug("Get Beer by Id - in service. Id: " + id.toString());

        return beerMap.get(id);
    }
}
