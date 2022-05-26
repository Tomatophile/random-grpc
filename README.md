## gRPC Kotlin Spring sample

```protobuf
syntax = "proto3";

import "google/protobuf/empty.proto";

message Seed{
  int64 value = 1;
}

message IntValue{
  int32 value = 1;
}

service RandomService{
  rpc RandomInt(google.protobuf.Empty) returns (IntValue);
  rpc RandomIntFromSeed(Seed) returns (IntValue);
}
```
