<template>
  <dv-water-level-pond :config="config" style="width:150px;height:200px" />
</template>
<script>
export default {
  data() {
    return {
      config: {
        data: [76],
        shape: "roundRect",
        formatter: "90",
        waveNum: 1,
      },
    };
  },
};
</script>
