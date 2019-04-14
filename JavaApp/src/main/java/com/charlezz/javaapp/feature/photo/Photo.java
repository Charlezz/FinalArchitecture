package com.charlezz.javaapp.feature.photo;

import androidx.recyclerview.selection.SelectionTracker;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Photo {
    private String name;
    private String path;
    private SelectionTracker<Long> selectionTracker;
    public Photo(String name, String path, SelectionTracker<Long> selectionTracker) {
        this.name = name;
        this.path = path;
        this.selectionTracker = selectionTracker;
    }
}
