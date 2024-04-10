/*
 * @ (#) .java   1.0    03/04/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package util;/*
 * @description:
 * @author:     Hoang Le
 * @date:       03/04/2024
 * @version:    1.0
 */

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
=======
import lombok.*;
>>>>>>> bc09ac6bc71855fd0fe3a69e903491144071f6c2
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
<<<<<<< HEAD
=======

>>>>>>> bc09ac6bc71855fd0fe3a69e903491144071f6c2
@Data
public class CustomIdGenerator implements IdentifierGenerator {
    private String prefix;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        LocalDateTime currentDateTime = LocalDateTime.now();
        String formattedDateTime = currentDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        System.out.println(prefix + formattedDateTime);
<<<<<<< HEAD
=======

>>>>>>> bc09ac6bc71855fd0fe3a69e903491144071f6c2
        return prefix + formattedDateTime;
    }
}

