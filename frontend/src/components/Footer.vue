<template>
    <div class="version">
        <span>版本号：v1.0.0</span>
        <a target="_blank" href="https://github.com/Yedaz/template">项目地址</a>
    </div>
</template>
<script setup>
    import dayjs from 'dayjs';
    const currentYear = dayjs().year();
</script>

<style lang="less" scoped>
    .version,.copyright{
        font-size: 14px;
        color: #000000;
        a:hover{
            color: #0a0e14;
        }
    }
</style>