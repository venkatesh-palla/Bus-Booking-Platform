package com.example.bus.controller;

import com.example.bus.api.response.bus.ConnectedBusApiResponse;
import com.example.bus.entity.BusType;
import com.example.bus.api.request.bus.BusRequest;
import com.example.bus.api.response.bus.BusResponse;
import com.example.bus.service.bus.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/Bus")
public class BusController {

    @Autowired
    BusService busService;

    @PostMapping("/create")
    public BusResponse create(@RequestBody BusRequest busRequest)
    {
        return busService.create(busRequest);
    }

    @PutMapping("/update")
    public BusResponse update(@RequestBody BusRequest busRequest)
    {
        return busService.update(busRequest);
    }

    @DeleteMapping("/delete/{BusId}")
    public void delete(@PathVariable String BusId)
    {
        busService.delete(BusId);
    }

    @GetMapping("/getAllBuses")
    public List<BusResponse>  getBusData()
    {
        return busService.getBuses();
    }

    @GetMapping("/getBusByName/{busName}")
    public List<BusResponse> getBusByName(@PathVariable String busName)
    {
        return busService.getBusByName(busName);
    }

    @GetMapping("/getBusBySourceAndDestinationByTime/{source}/{destination}/{date}")
    public List<BusResponse> getBusBySourceAndDestinationByTime(@PathVariable String source, @PathVariable String destination, @PathVariable Date date)
    {

        return busService.getBusBySourceAndDestinationByTime(source,destination,date);
    }

    @GetMapping("/getBusBytime/{time}")
    public List<BusResponse> getBusByTime(@PathVariable Timestamp time)
    {
        return busService.getBusByTime(time);
    }


    @GetMapping("/busType/{bustype}")
    public List<BusResponse> busType(@PathVariable BusType busType)
    {
       return busService.busType(busType);
    }

    @GetMapping("/connectedBuses/{firstBusSource}/{secondBusDestination}")
    public List<ConnectedBusApiResponse> connectedBuses(@PathVariable String firstBusSource,
                                                        @PathVariable String secondBusDestination )
    {
       return busService.getConnectedBuses(firstBusSource,secondBusDestination);
    }
}
