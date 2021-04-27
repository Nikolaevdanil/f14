package com.example.demo.dao;


import com.example.demo.models.Manufacture;
import com.example.demo.models.Worker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Neil Alishev
 */
@Component
public class PersonDAO {
    private static int WORKER_COUNT;
    private static int MANUFACTURE_COUNT;
    private List<Worker> workers;
    private List<Manufacture>manufactures;

    {
        manufactures=new ArrayList<>();
        workers=new ArrayList<>();
        workers.add(new Worker(++WORKER_COUNT,"Danil","Nikolaev","Aleksandqw"));
        manufactures.add(new Manufacture(++MANUFACTURE_COUNT,"Apple","yl.Dimirova 15 k.2"));

    }
    public List<Worker> index1() {
        return workers;
    }
    public List<Manufacture> index2() {
        return manufactures;
    }

    public Worker show(int id) {
        return workers.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Manufacture manufacture,Worker worker) {
        worker.setId(++WORKER_COUNT);
        manufacture.setId(++MANUFACTURE_COUNT);
        workers.add(worker);
        manufactures.add(manufacture);
    }

    public void delete(int id) {
        workers.removeIf(p -> p.getId() == id);
        manufactures.removeIf(p -> p.getId() == id);
    }

}