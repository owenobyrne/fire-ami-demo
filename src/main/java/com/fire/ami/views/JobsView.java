package com.fire.ami.views;

import com.fire.ami.models.Job;
import com.fire.ami.repositories.JobsRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

@UIScope
@Route(value = "jobs", layout = IndexView.class)
public class JobsView extends VerticalLayout {
    private JobsForm jobsForm;

    private JobsRepository jobsRepository;
    private Grid<Job> grid = new Grid<>(Job.class);
    private TextField filterTextField = new TextField();
    Button addJobsButton = new Button("Add new Job");


    public JobsView(@Autowired JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
        jobsForm = new JobsForm(this, jobsRepository);
        jobsForm.setJob(null, false); // hide the form

        addJobsButton.addClickListener(e -> {
            grid.asSingleSelect().clear();
            jobsForm.setJob(new Job(), true);
        });

        filterTextField.setPlaceholder("Filter by name...");
        filterTextField.setClearButtonVisible(true);
        filterTextField.setValueChangeMode(ValueChangeMode.EAGER);
        filterTextField.addValueChangeListener(e -> filterList());

        HorizontalLayout toolbar = new HorizontalLayout(filterTextField, addJobsButton);

        grid.setColumns("name");//, "dn", "directoryType");
        grid.getColumns().forEach(column -> column.setAutoWidth(true));

        HorizontalLayout mainContent = new HorizontalLayout(grid, jobsForm);
        mainContent.setSizeFull();
        grid.setSizeFull();

        add(toolbar, mainContent);
        setSizeFull();
        updateList();

        grid.asSingleSelect().addValueChangeListener(
                event -> jobsForm.setJob(grid.asSingleSelect().getValue(), false));

    }

    public void updateList() {
        grid.setItems(jobsRepository.getJobs());
        grid.recalculateColumnWidths();
    }

    public void filterList() {
        grid.setItems(jobsRepository.getJobsWithFilter(filterTextField.getValue()));
        grid.recalculateColumnWidths();
    }
}
