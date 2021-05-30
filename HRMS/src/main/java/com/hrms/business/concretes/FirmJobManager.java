package com.hrms.business.concretes;

import com.hrms.business.abstracts.FirmJobService;
import com.hrms.business.abstracts.FirmService;
import com.hrms.business.abstracts.JobService;
import com.hrms.business.abstracts.ProvinceService;
import com.hrms.core.utilities.results.*;
import com.hrms.dataAccess.abstracts.FirmJobDao;
import com.hrms.entities.concretes.FirmJob;
import com.hrms.entities.concretes.Job;
import com.hrms.entities.dtos.AddFirmJobModel;
import com.hrms.entities.dtos.JobDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FirmJobManager implements FirmJobService {
    @Autowired
    private FirmJobDao _firmJobDao;

    @Autowired
    private FirmService _firmService;

    @Autowired
    private JobService _jobService;

    @Autowired
    private ProvinceService _provinceService;

    @Override
    public Result addJob(AddFirmJobModel model) {
        FirmJob newJob = new FirmJob(
          0,
            model.getExplanation(),
            model.getPriceMin(),
            model.getPriceMax(),
            model.getJobCount(),
            model.getStartDate(),
            model.getEndDate(),
            true,
            _jobService.getJobById(model.getJobId()),
            _provinceService.getProvinceById(model.getProvinceId()),
            _firmService.getFirmById(model.getFirmId())
        );
        _firmJobDao.save(newJob);
        if (newJob.getId() > 0){
            return new SuccessResult("Kayıt başarılı");
        }else {
            return new ErrorResult("Kayıt başarısız");
        }
    }

    @Override
    public DataResult<List<JobDetailModel>> getAllJobs() {
        List<FirmJob> listJob = _firmJobDao.findByIsActiveTrue();
        List<JobDetailModel> returnList = mapToDetailDto(listJob);
        return new SuccessDataResult<List<JobDetailModel>>(returnList, "Listeleme başarılı");
    }

    @Override
    public DataResult<List<JobDetailModel>> getAllJobsOrderBy() {
        List<FirmJob> listJob = _firmJobDao.findByIsActiveTrueOrderByEndDate();
        List<JobDetailModel> returnList = mapToDetailDto(listJob);
        return new SuccessDataResult<List<JobDetailModel>>(returnList, "Listeleme başarılı");
    }

    @Override
    public DataResult<List<JobDetailModel>> getAllJobsByFirm(int id) {
        List<FirmJob> listJob = _firmJobDao.findByFirm_FirmId(id);
        List<JobDetailModel> returnList = mapToDetailDto(listJob);
        return new SuccessDataResult<List<JobDetailModel>>(returnList, "Listeleme başarılı");
    }

    private List<JobDetailModel> mapToDetailDto(List<FirmJob> model) {
        List<JobDetailModel> returnList = new ArrayList<JobDetailModel>();
        for(FirmJob fj : model) {
            returnList.add(new JobDetailModel(
                    fj.getFirm().getFirmName(),
                    fj.getJob().getJobName(),
                    fj.getJobCount(),
                    fj.getStartDate(),
                    fj.getEndDate()
            ));
        }
        return returnList;
    }
}
