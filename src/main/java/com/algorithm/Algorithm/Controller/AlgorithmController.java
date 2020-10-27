package com.algorithm.Algorithm.Controller;

import java.util.*;
import com.algorithm.Algorithm.SpanningTreeAlgorithms.Common.EuropeanValues;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class AlgorithmController {

  @RequestMapping(value = "/prim", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String>  prim(@RequestParam(value = "startingEdge") String startingEdge){
    System.out.print("this is the users chosen starting edge: " + startingEdge.toUpperCase() + "    ");
      EuropeanValues value = new EuropeanValues();
      return value.getResults(startingEdge.toUpperCase(), "Prim");
    }

  @RequestMapping(value = "/Kruskal's", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public List<String>  kruskal() {
    EuropeanValues value = new EuropeanValues();
    System.out.println("my result    "  + value.getResults("", "Kruskal"));
    return value.getResults("", "Kruskal");
  }

  @RequestMapping(value = "/Boruvkas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public List<String>  boruvka() {
    EuropeanValues value = new EuropeanValues();
    return value.getResults("", "Boruvka");
  }



}
