create keyspace observatory
with replication = {'class' : 'SimpleStrategy', 'replication_factor': 1};

use observatory;

create table exception_occurrences(
  exception_id uuid,
  occured_at timestamp,
  occurrence_id uuid,
  canonical_class_name text,
  throw_location text,
  catch_location text,
  host text,
  process_pid int,
  thread_name text,
  message text,
  stack_frames text,
  primary key (exception_id, occured_at, occurrence_id))
  with clustering order by (occured_at asc);


