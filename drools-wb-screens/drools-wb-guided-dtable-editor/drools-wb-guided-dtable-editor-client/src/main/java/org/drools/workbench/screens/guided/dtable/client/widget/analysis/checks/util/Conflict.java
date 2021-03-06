/*
 * Copyright 2015 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.workbench.screens.guided.dtable.client.widget.analysis.checks.util;

import java.util.Collection;

public class Conflict {

    public static boolean isConflicting( Collection collection,
                                         Collection otherCollection ) {

        if ( collection == null || otherCollection == null ) {
            return false;
        }

        for ( Object o : collection ) {
            if ( o instanceof IsConflicting ) {
                if ( hasConflictingObjectInList( otherCollection, (IsConflicting) o ) ) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean hasConflictingObjectInList( Collection collection,
                                                      IsConflicting isConflicting ) {
        if ( isConflicting == null || collection == null ) {
            return false;
        }

        for ( Object other : collection ) {
            if ( isConflicting.conflicts( other ) ) {
                return true;
            }
        }
        return false;
    }
}
