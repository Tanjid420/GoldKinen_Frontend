

// eslint-disable-next-line react/prop-types
function Button({handleClick,isOpen}) {
  return (
   <div onClick = {()=> handleClick()} className="mt-12 w-[15%]"> <a href="#_" className="relative px-6 py-3 font-bold text-black group hover:text-black">
<span className="absolute inset-0 w-full h-full transition duration-300 ease-out transform -translate-x-2 -translate-y-2 bg-red-300 group-hover:translate-x-0 group-hover:translate-y-0 hover:text-black"></span>
<span className="absolute inset-0 w-full h-full border-4 border-black"></span>
<span className="relative">{isOpen ? 'Hide Comments' : 'Show Comments'}</span>
</a>
</div>
  )
}

export default Button