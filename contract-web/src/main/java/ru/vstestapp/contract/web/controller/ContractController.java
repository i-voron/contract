package ru.vstestapp.contract.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.vstestapp.contract.api.calculation.InsuranceCalculator;
import ru.vstestapp.contract.entity.Contract;
import ru.vstestapp.contract.entity.Insurance;
import ru.vstestapp.contract.entity.Insurant;
import ru.vstestapp.contract.service.ContractService;
import ru.vstestapp.contract.service.InsurantService;
import ru.vstestapp.contract.service.ReferenceRtService;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping({"/", "/index"})
public class ContractController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private InsurantService insurantService;
    @Autowired
    private ReferenceRtService rtService;
    @Autowired
    private InsuranceCalculator insuranceCalculator;

    @ModelAttribute(name = "rtList")
    public List rtList() {
        return rtService.findAll();
    }

    @GetMapping
    public String showDesignForm() {
        return "index";
    }

    @GetMapping(value = "/jsonContractData", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map jsonContractData(Model model) {
        List<Contract> rows = contractService.findAll();
        Map m = new HashMap();
        m.put("rows", rows);
        return m;
    }

//    @GetMapping("/contractForm/{id:\\d*}")
    @GetMapping(value = {"/contractForm", "/contractForm/{id}"})
    public String showContractForm(@PathVariable(value = "id", required = false) Long id, Model model) {
        Contract contract = null;
        contract = id == null ? new Contract() : contractService.findById(id).orElse(new Contract());
        model.addAttribute("contract", contract);
        return "contractForm";
    }
    @PostMapping(value = {"/contractForm", "/contractForm/{id}"})
    public String contractFormSave(@ModelAttribute @Valid Contract contract, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "contractForm";
        }

        contractService.save(contract);
        model.addAttribute("contract", contract);

        return "contractForm";
    }

    @PostMapping(value = "/jsonInsuranceCalculate", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Map jsonInsuranceCalculate(@RequestBody @Validated Insurance insurance, BindingResult bindingResult) {
        Map<String, Object> m = new HashMap<>();
        List<ObjectError> errGlob = bindingResult.getGlobalErrors();
        List<FieldError> err = bindingResult.getFieldErrors();
        err = err.stream().
                filter(fieldError -> !fieldError.getField().equals("calculationDate") &&
                        !fieldError.getField().equals("insurancePremium")).collect(Collectors.toList());
        if (!err.isEmpty()) {
            m.put("errors", err);
        } else {
            if (insurance != null) {
                if (insurance.getRealtyType().getId() != 0) {
                    insurance.setRealtyType(rtService.findById(insurance.getRealtyType().getId()).orElse(null));
                }
                insurance.setInsurancePremium(insuranceCalculator.calculate(insurance));
                insurance.setCalculationDate(new Date());
            }
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            m.put("calculationDate", dateFormat.format(insurance.getCalculationDate()));
            m.put("insurancePremium", insurance.getInsurancePremium());
        }
        return m;
    }

    @GetMapping("/insurantSelect")
    public String showInsurantSelect() {
        return "insurantSelect";
    }

    @PostMapping(value = "/jsonInsurantSelectData", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
//    public ResponseEntity jsonInsurantSelectData(@RequestBody Insurant insurant) {
    public List jsonInsurantSelectData(@RequestBody Insurant insurant, Errors errors, BindingResult bindingResult) {
        List<Insurant> rows = Collections.emptyList();
        if (insurant != null) {
            rows = insurantService.findFio(insurant.getSurname(), insurant.getName(), insurant.getPatronymic());
        }
//        return new ResponseEntity(rows,HttpStatus.OK);
        return rows;
    }

    @GetMapping("/insurantEditForm")
    public String showInsurantForm() {
        return "insurantEditForm";
    }
    @PostMapping(value = "/jsonSaveInsurantFormData", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Map jsonSaveInsurantFormData(@Validated @RequestBody Insurant insurant, Errors errors, BindingResult bindingResult) {
        Map<String, Object> m = new HashMap<>();
        List<ObjectError> errGlob = bindingResult.getGlobalErrors();
        List<FieldError> err = bindingResult.getFieldErrors();

        if (!err.isEmpty()) {
            m.put("errors", err);
        } else {
            if (insurant != null) {
                insurant=insurantService.save(insurant);
                m.put("insurant", insurant);
            }
        }
        return m;
    }

}
