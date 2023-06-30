package com.citbarueri.cursos.model;

import java.time.LocalDateTime;

import com.citbarueri.cursos.entities.Address;
import com.citbarueri.cursos.entities.Host;
import com.citbarueri.cursos.entities.CategoryPrim;
import com.citbarueri.cursos.entities.CategorySec;

public class Cursos {
    
    private int id;
    private String startDate;
    private String endDate;
    private String name;
    private String detail;
    private int private_event;
    private int published;
    private int cancelled;
    private String image;
    private String url;
    private Address address;
    private Host host;
    private CategoryPrim categoryPrim;
    private CategorySec categorySec;
    
    public Cursos() {}

    public Cursos(int id, String startDate, String endDate, String name, String detail, int private_event,
    int published, int cancelled, String image, String url, Address address, Host host, CategoryPrim categoryPrim,
    CategorySec categorySec) {
        
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
        this.detail = detail;
        this.private_event = private_event;
        this.published = published;
        this.cancelled = cancelled;
        this.image = image;
        this.url = url;
        this.address = address;
        this.host = host;
        this.categoryPrim = categoryPrim;
        this.categorySec = categorySec;

    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getStartDate() {
        return this.startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public String getEndDate() {
        return this.endDate;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    public String getDetail() {
        return this.detail;
    }

    public void setPrivate_Event(int private_event) {
        this.private_event = private_event;
    }
    public int getPrivate_Event() {
        return this.private_event;
    }

    public void setPublished(int published) {
        this.published = published;
    }
    public int getPublished() {
        return this.published;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }
    public int getCancelled() {
        return this.cancelled;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getImage() {
        return this.image;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return this.url;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public Address getAddress() {
        return this.address;
    }

    public void setHost(Host host) {
        this.host = host;
    }
    public Host getHost() {
        return this.host;
    }

    public void setCategoryPrim(CategoryPrim categoryPrim) {
        this.categoryPrim = categoryPrim;
    }
    public CategoryPrim getCategoryPrim() {
        return this.categoryPrim;
    }

    public void setCategorySec(CategorySec categorySec) {
        this.categorySec = categorySec;
    }
    public CategorySec getCategorySec() {
        return this.categorySec;
    }
    
    public boolean isEnded() {
        LocalDateTime today = LocalDateTime.now();
        String[] date = this.endDate.split(" ");
        String[] dateD = date[0].split("-");
        String[] hour = date[1].split(":");
        int[] numDate = {Integer.parseInt(dateD[0]), Integer.parseInt(dateD[1]), Integer.parseInt(dateD[2]),
            Integer.parseInt(hour[0]), Integer.parseInt(hour[1]), Integer.parseInt(hour[2])};

        date = null;
        dateD = null;
        hour = null;

        int[] numTodayDate = {today.getYear(), today.getMonthValue(), today.getDayOfMonth(),
            today.getHour(), today.getMinute(), today.getSecond()};

        if (numDate[0] <= numTodayDate[0]) {
            
            if (numDate[0] == numTodayDate[0]) {
                
                if (numDate[1] <= numTodayDate[1]) {
            
                    if (numDate[1] == numTodayDate[1]) {
                        
                        if (numDate[2] <= numTodayDate[2]) {
            
                            if (numDate[2] == numTodayDate[2]) {
                                
                                if (numDate[3] <= numTodayDate[3]) {
            
                                    if (numDate[3] == numTodayDate[3]) {
                                        
                                        if (numDate[4] <= numTodayDate[4]) {
            
                                            if (numDate[4] == numTodayDate[4]) {
                                                
                                                if (numDate[5] < numTodayDate[5]) {
                                                    return true;
                                                }
                                                return false;
                                                
                                            }
                                            return true;

                                        }
                                        return false;
                                        
                                    }
                                    return true;

                                }
                                return false;

                            }
                            return true;

                        }
                        return false;
                        
                    }
                    return true;

                }
                return false;

            }
            return true;

        }

        return false;
    }


}
