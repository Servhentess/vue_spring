<script setup>
import { ref, onMounted } from 'vue'

const message = ref('chargement...')

onMounted(async () => {
  const res = await fetch('/api/hello')
  const data = await res.json()
  message.value = data.message
})
</script>

<template>
  <main style="padding: 2rem">
    <h1>{{ message }}</h1>
  </main>
</template>
