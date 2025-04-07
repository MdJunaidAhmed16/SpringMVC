package com.example.springMVC.services;

import java.util.List;
import java.util.UUID;

import com.example.springMVC.model.Beer;

/**
 * Created by jt, Spring Framework Guru.
 */
public interface BeerService {

    Beer getBeerById(UUID id);

    List<Beer> listBeers();
}
