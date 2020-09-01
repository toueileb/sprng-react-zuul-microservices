package org.sid.pathologyservicems.resources;

import org.sid.pathologyservicems.models.Disease;
import org.sid.pathologyservicems.models.DiseasesList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/pathalogy")
public class PathalogyResource {

    List<Disease> diseases = Arrays.asList(
            new Disease("D1", "Ashma", "Warm water bath"),
            new Disease("D2", "Thyphoid", "Ampicilin capsule!")
    );

    @RequestMapping("/diseases")
    public DiseasesList getDiseases() {
        DiseasesList diseasesList = new DiseasesList();
        diseasesList.setDiseases(diseases);
        return diseasesList;
    }

    @RequestMapping("/diseases/{id}")
    public Disease getDiseaseById(@PathVariable("id") String id) {
        Disease returnedDisease = diseases.stream()
                .filter(disease -> id.equals(disease.getId()))
                .findAny()
                .orElse(null);
        return returnedDisease;

    }
}
