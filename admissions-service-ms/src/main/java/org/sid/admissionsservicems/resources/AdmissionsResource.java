package org.sid.admissionsservicems.resources;

import org.sid.admissionsservicems.models.DiseasesList;
import org.sid.admissionsservicems.models.EmployeesList;
import org.sid.admissionsservicems.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/admissions")
public class AdmissionsResource {

    @Autowired
    private RestTemplate restTemplate;

    List<Patient> patients = Arrays.asList(
            new Patient("p1","Gabon","Hungarian"),
            new Patient("p2","Emeka","Nigerian"),
            new Patient("p3","Emily","American")
    );

    @RequestMapping("/physicians")
    public EmployeesList getPhysicians(){
        EmployeesList employeesList = restTemplate.getForObject("http://localhost:8082/hr/employees",EmployeesList.class);
        return employeesList;
    }

    @RequestMapping("/diseases")
    public DiseasesList getDiseases(){
        DiseasesList diseasesList = restTemplate.getForObject("http://localhost:8083/pathalogy/diseases",DiseasesList.class);
        return diseasesList;
    }

    @RequestMapping("/patients")
    public List<Patient> getPatients(){
        return patients;
    }

    @RequestMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable("id") String id){
        Patient returnedPatient = patients.stream().filter(patient -> id.equals(patient.getId()))
                .findAny()
                .orElse(null);
        return returnedPatient;

    }
}
