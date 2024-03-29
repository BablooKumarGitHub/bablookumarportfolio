package com.udayam.bablookumar.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="projects", indexes = @Index(name = "date_order_ind", columnList = "date_order"))
public class Project {
    
    public static final String PROJECT_ID_ERROR = "Invalid 'id', project not found.";
    public static final String PROJECT_NAME_ERROR = "'name' should be between 3-30 characters.";
    public static final String PROJECT_DESCRIPTION_ERROR = "'description' should be between 10-250 characters.";
    public static final String PROJECT_START_DATE_ERROR = "'startDate' should be in format 'MM/YYYY'.";
    public static final String PROJECT_END_DATE_ERROR = "'endDate' should be in format 'MM/YYYY'.";
    public static final String PROJECT_LINK_ERROR = "'link' should be between 4-250 characters.";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    @Size(min = 3, max = 30, message = PROJECT_NAME_ERROR)
    @NotBlank(message = PROJECT_NAME_ERROR)
    private String name;

    @Column(name = "description", nullable = false)
    @Size(min = 10, max = 250, message = PROJECT_DESCRIPTION_ERROR)
    @NotBlank(message = PROJECT_DESCRIPTION_ERROR)
    private String description;

    @Column(name = "start_date", nullable = false)
    @Pattern(regexp = "^(0[1-9]|1[0-2])/20[0-9]{2}$", message = PROJECT_START_DATE_ERROR)
    @NotBlank(message = PROJECT_START_DATE_ERROR)
    private String startDate;

    @Column(name = "end_date", nullable = false)
    @Pattern(regexp = "^(0[1-9]|1[0-2])/20[0-9]{2}$", message = PROJECT_END_DATE_ERROR)
    @NotBlank(message = PROJECT_END_DATE_ERROR)
    private String endDate;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Column(name = "date_order", nullable = false)
    private String dateOrder;

    @Column(name = "skills")
    @ManyToMany(mappedBy = "projects", fetch = FetchType.LAZY)
    @OrderBy("name ASC")
    private final Set<Skill> skills = new HashSet<>();

    @Column(name = "link", nullable = false)
    @Size(min = 4, max = 250, message = PROJECT_LINK_ERROR)
    @NotBlank(message = PROJECT_LINK_ERROR)
    private String link;

    public void createOrder() {
        StringBuilder sb = new StringBuilder(14);
        sb.append(startDate.substring(3));
        sb.append(startDate.substring(0, 2));
        sb.append(endDate.substring(3));
        sb.append(endDate.substring(0, 2));
        this.dateOrder = sb.toString();
    }

    public void addSkill(Skill skill) {
        skill.getProjects().add(this);
        this.skills.add(skill);
    }

    public void deleteSkill(Skill skill) {
        skill.getProjects().remove(this);
        this.skills.remove(skill);
    }
}
