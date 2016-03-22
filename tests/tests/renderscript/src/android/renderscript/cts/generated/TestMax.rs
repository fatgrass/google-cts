/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Don't edit this file!  It is auto-generated by frameworks/rs/api/generate.sh.

#pragma version(1)
#pragma rs java_package_name(android.renderscript.cts)

rs_allocation gAllocInB;

float __attribute__((kernel)) testMaxFloatFloatFloat(float inA, unsigned int x) {
    float inB = rsGetElementAt_float(gAllocInB, x);
    return max(inA, inB);
}

float2 __attribute__((kernel)) testMaxFloat2Float2Float2(float2 inA, unsigned int x) {
    float2 inB = rsGetElementAt_float2(gAllocInB, x);
    return max(inA, inB);
}

float3 __attribute__((kernel)) testMaxFloat3Float3Float3(float3 inA, unsigned int x) {
    float3 inB = rsGetElementAt_float3(gAllocInB, x);
    return max(inA, inB);
}

float4 __attribute__((kernel)) testMaxFloat4Float4Float4(float4 inA, unsigned int x) {
    float4 inB = rsGetElementAt_float4(gAllocInB, x);
    return max(inA, inB);
}

half __attribute__((kernel)) testMaxHalfHalfHalf(half inA, unsigned int x) {
    half inB = rsGetElementAt_half(gAllocInB, x);
    return max(inA, inB);
}

half2 __attribute__((kernel)) testMaxHalf2Half2Half2(half2 inA, unsigned int x) {
    half2 inB = rsGetElementAt_half2(gAllocInB, x);
    return max(inA, inB);
}

half3 __attribute__((kernel)) testMaxHalf3Half3Half3(half3 inA, unsigned int x) {
    half3 inB = rsGetElementAt_half3(gAllocInB, x);
    return max(inA, inB);
}

half4 __attribute__((kernel)) testMaxHalf4Half4Half4(half4 inA, unsigned int x) {
    half4 inB = rsGetElementAt_half4(gAllocInB, x);
    return max(inA, inB);
}

float2 __attribute__((kernel)) testMaxFloat2FloatFloat2(float2 inA, unsigned int x) {
    float inB = rsGetElementAt_float(gAllocInB, x);
    return max(inA, inB);
}

float3 __attribute__((kernel)) testMaxFloat3FloatFloat3(float3 inA, unsigned int x) {
    float inB = rsGetElementAt_float(gAllocInB, x);
    return max(inA, inB);
}

float4 __attribute__((kernel)) testMaxFloat4FloatFloat4(float4 inA, unsigned int x) {
    float inB = rsGetElementAt_float(gAllocInB, x);
    return max(inA, inB);
}

half2 __attribute__((kernel)) testMaxHalf2HalfHalf2(half2 inA, unsigned int x) {
    half inB = rsGetElementAt_half(gAllocInB, x);
    return max(inA, inB);
}

half3 __attribute__((kernel)) testMaxHalf3HalfHalf3(half3 inA, unsigned int x) {
    half inB = rsGetElementAt_half(gAllocInB, x);
    return max(inA, inB);
}

half4 __attribute__((kernel)) testMaxHalf4HalfHalf4(half4 inA, unsigned int x) {
    half inB = rsGetElementAt_half(gAllocInB, x);
    return max(inA, inB);
}

char __attribute__((kernel)) testMaxCharCharChar(char inA, unsigned int x) {
    char inB = rsGetElementAt_char(gAllocInB, x);
    return max(inA, inB);
}

char2 __attribute__((kernel)) testMaxChar2Char2Char2(char2 inA, unsigned int x) {
    char2 inB = rsGetElementAt_char2(gAllocInB, x);
    return max(inA, inB);
}

char3 __attribute__((kernel)) testMaxChar3Char3Char3(char3 inA, unsigned int x) {
    char3 inB = rsGetElementAt_char3(gAllocInB, x);
    return max(inA, inB);
}

char4 __attribute__((kernel)) testMaxChar4Char4Char4(char4 inA, unsigned int x) {
    char4 inB = rsGetElementAt_char4(gAllocInB, x);
    return max(inA, inB);
}

uchar __attribute__((kernel)) testMaxUcharUcharUchar(uchar inA, unsigned int x) {
    uchar inB = rsGetElementAt_uchar(gAllocInB, x);
    return max(inA, inB);
}

uchar2 __attribute__((kernel)) testMaxUchar2Uchar2Uchar2(uchar2 inA, unsigned int x) {
    uchar2 inB = rsGetElementAt_uchar2(gAllocInB, x);
    return max(inA, inB);
}

uchar3 __attribute__((kernel)) testMaxUchar3Uchar3Uchar3(uchar3 inA, unsigned int x) {
    uchar3 inB = rsGetElementAt_uchar3(gAllocInB, x);
    return max(inA, inB);
}

uchar4 __attribute__((kernel)) testMaxUchar4Uchar4Uchar4(uchar4 inA, unsigned int x) {
    uchar4 inB = rsGetElementAt_uchar4(gAllocInB, x);
    return max(inA, inB);
}

short __attribute__((kernel)) testMaxShortShortShort(short inA, unsigned int x) {
    short inB = rsGetElementAt_short(gAllocInB, x);
    return max(inA, inB);
}

short2 __attribute__((kernel)) testMaxShort2Short2Short2(short2 inA, unsigned int x) {
    short2 inB = rsGetElementAt_short2(gAllocInB, x);
    return max(inA, inB);
}

short3 __attribute__((kernel)) testMaxShort3Short3Short3(short3 inA, unsigned int x) {
    short3 inB = rsGetElementAt_short3(gAllocInB, x);
    return max(inA, inB);
}

short4 __attribute__((kernel)) testMaxShort4Short4Short4(short4 inA, unsigned int x) {
    short4 inB = rsGetElementAt_short4(gAllocInB, x);
    return max(inA, inB);
}

ushort __attribute__((kernel)) testMaxUshortUshortUshort(ushort inA, unsigned int x) {
    ushort inB = rsGetElementAt_ushort(gAllocInB, x);
    return max(inA, inB);
}

ushort2 __attribute__((kernel)) testMaxUshort2Ushort2Ushort2(ushort2 inA, unsigned int x) {
    ushort2 inB = rsGetElementAt_ushort2(gAllocInB, x);
    return max(inA, inB);
}

ushort3 __attribute__((kernel)) testMaxUshort3Ushort3Ushort3(ushort3 inA, unsigned int x) {
    ushort3 inB = rsGetElementAt_ushort3(gAllocInB, x);
    return max(inA, inB);
}

ushort4 __attribute__((kernel)) testMaxUshort4Ushort4Ushort4(ushort4 inA, unsigned int x) {
    ushort4 inB = rsGetElementAt_ushort4(gAllocInB, x);
    return max(inA, inB);
}

int __attribute__((kernel)) testMaxIntIntInt(int inA, unsigned int x) {
    int inB = rsGetElementAt_int(gAllocInB, x);
    return max(inA, inB);
}

int2 __attribute__((kernel)) testMaxInt2Int2Int2(int2 inA, unsigned int x) {
    int2 inB = rsGetElementAt_int2(gAllocInB, x);
    return max(inA, inB);
}

int3 __attribute__((kernel)) testMaxInt3Int3Int3(int3 inA, unsigned int x) {
    int3 inB = rsGetElementAt_int3(gAllocInB, x);
    return max(inA, inB);
}

int4 __attribute__((kernel)) testMaxInt4Int4Int4(int4 inA, unsigned int x) {
    int4 inB = rsGetElementAt_int4(gAllocInB, x);
    return max(inA, inB);
}

uint __attribute__((kernel)) testMaxUintUintUint(uint inA, unsigned int x) {
    uint inB = rsGetElementAt_uint(gAllocInB, x);
    return max(inA, inB);
}

uint2 __attribute__((kernel)) testMaxUint2Uint2Uint2(uint2 inA, unsigned int x) {
    uint2 inB = rsGetElementAt_uint2(gAllocInB, x);
    return max(inA, inB);
}

uint3 __attribute__((kernel)) testMaxUint3Uint3Uint3(uint3 inA, unsigned int x) {
    uint3 inB = rsGetElementAt_uint3(gAllocInB, x);
    return max(inA, inB);
}

uint4 __attribute__((kernel)) testMaxUint4Uint4Uint4(uint4 inA, unsigned int x) {
    uint4 inB = rsGetElementAt_uint4(gAllocInB, x);
    return max(inA, inB);
}

long __attribute__((kernel)) testMaxLongLongLong(long inA, unsigned int x) {
    long inB = rsGetElementAt_long(gAllocInB, x);
    return max(inA, inB);
}

long2 __attribute__((kernel)) testMaxLong2Long2Long2(long2 inA, unsigned int x) {
    long2 inB = rsGetElementAt_long2(gAllocInB, x);
    return max(inA, inB);
}

long3 __attribute__((kernel)) testMaxLong3Long3Long3(long3 inA, unsigned int x) {
    long3 inB = rsGetElementAt_long3(gAllocInB, x);
    return max(inA, inB);
}

long4 __attribute__((kernel)) testMaxLong4Long4Long4(long4 inA, unsigned int x) {
    long4 inB = rsGetElementAt_long4(gAllocInB, x);
    return max(inA, inB);
}

ulong __attribute__((kernel)) testMaxUlongUlongUlong(ulong inA, unsigned int x) {
    ulong inB = rsGetElementAt_ulong(gAllocInB, x);
    return max(inA, inB);
}

ulong2 __attribute__((kernel)) testMaxUlong2Ulong2Ulong2(ulong2 inA, unsigned int x) {
    ulong2 inB = rsGetElementAt_ulong2(gAllocInB, x);
    return max(inA, inB);
}

ulong3 __attribute__((kernel)) testMaxUlong3Ulong3Ulong3(ulong3 inA, unsigned int x) {
    ulong3 inB = rsGetElementAt_ulong3(gAllocInB, x);
    return max(inA, inB);
}

ulong4 __attribute__((kernel)) testMaxUlong4Ulong4Ulong4(ulong4 inA, unsigned int x) {
    ulong4 inB = rsGetElementAt_ulong4(gAllocInB, x);
    return max(inA, inB);
}
