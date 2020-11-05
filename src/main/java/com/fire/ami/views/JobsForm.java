package com.fire.ami.views;

import com.fire.ami.models.Job;
import com.fire.ami.repositories.JobsRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.UIScope;


@UIScope
public class JobsForm extends FormLayout {
    private JobsView jobsView;

    private JobsRepository jobsRepository;

    private TextField name = new TextField("TSP Name");
    private TextArea certData = new TextArea("Certificate Data");
    private TextArea dn = new TextArea("Distinguished Name (DN)");

    private Button save = new Button("Save");
    private Button delete = new Button("Delete");

    private Binder<Job> binder = new Binder<>(Job.class);

    public JobsForm(JobsView jobsView, JobsRepository jobsRepository) {
        this.jobsView = jobsView;
        this.jobsRepository = jobsRepository;

        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        // as my TrustedCa member fields are private, Vaadin can't see them, so I must explicitly link the fields to the getters/setters.
        binder.bind(name, Job::getName, Job::setName);
//        binder.bind(dn, Job::getDn, Job::setDn);
//        binder.bind(certData, Job::getCert, Job::setCert);

        dn.setReadOnly(true);

        add(name, dn, certData, buttons);

        save.addClickListener(event -> save());
        delete.addClickListener(event -> delete());

    }

    public void setJob(Job job, boolean newJob) {
        binder.setBean(job);

        if (newJob) {
            name.setVisible(false);
            dn.setVisible(false);
        } else {
            name.setVisible(true);
            dn.setVisible(true);
        }

        if (job == null) {
            setVisible(false);
        } else {
            setVisible(true);
        }
    }

    private void save() {
        Job job = binder.getBean();

//        X509Certificate certificate = X509Utilities.decodeCertificateData(Job.getCert());
//        job.setDn(X509Utilities.canonicalizeDN(certificate.getSubjectX500Principal()));
//        X500Name x500Name = new X500Name(certificate.getSubjectX500Principal().getName(X500Principal.RFC1779));
//        job.setName(x500Name.getRDNs(BCStyle.CN)[0].getFirst().getValue().toString());

        job.setName("owen");

        jobsRepository.save(job);
        jobsView.updateList();
        setJob(null, false);
    }

    private void delete() {
        Job job = binder.getBean();
        jobsRepository.delete(job);
        jobsView.updateList();
        setJob(null, false);
    }
}