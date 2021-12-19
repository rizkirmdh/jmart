package com.RizkiRamadhanJmartPK.controller;

import com.RizkiRamadhanJmartPK.Algorithm;
import com.RizkiRamadhanJmartPK.dbjson.JSONTable;
import com.RizkiRamadhanJmartPK.dbjson.Serializable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public interface BasicGetController<T extends Serializable>
{
    public abstract JSONTable<T> getJsonTable();

    @RequestMapping(value="/page", method=RequestMethod.GET)
    public default List<T> getPage
            (
                    @RequestParam(defaultValue="0") int page,
                    @RequestParam(defaultValue="5") int pageSize
            )
    {
        final JSONTable<T> table = getJsonTable();
        return Algorithm.<T>paginate(table, page, pageSize, o -> true);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public default T getById(@PathVariable int id)
    {
        return Algorithm.<T>find(getJsonTable(), (e) -> e.id == id);
    }
}