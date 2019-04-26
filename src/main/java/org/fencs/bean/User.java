package org.fencs.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * .
 *
 * @author: haifeng
 * @date: 2019-04-25 14:36
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String address;
    private long timestamp;
}
